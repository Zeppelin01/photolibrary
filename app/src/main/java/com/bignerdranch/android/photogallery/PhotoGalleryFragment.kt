package com.bignerdranch.android.photogallery

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.photogallery.api.ImdbMovie
import com.bignerdranch.android.photogallery.moviedetail.MovieDetailActivity
import com.bignerdranch.android.photogallery.moviedetail.PHOTO_KEY
import com.bignerdranch.android.photogallery.search.MovieAdapter

private const val TAG = "PhotoGalleryFragment"

class PhotoGalleryFragment : Fragment() {

    lateinit var title:String

    companion object {
        fun newInstance() = PhotoGalleryFragment()
    }

    private lateinit var photoGalleryViewModel: PhotoGalleryViewModel
    private lateinit var photoRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        photoGalleryViewModel = ViewModelProvider(this).get(PhotoGalleryViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_photo_gallery, container, false)

        photoRecyclerView = view.findViewById(R.id.photo_recycler_view)
        photoRecyclerView.layoutManager = GridLayoutManager(context, 3)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title = (requireArguments().getString(MOVIE_ID).toString())

        photoGalleryViewModel.fetchMovies(title)

        photoGalleryViewModel.movieItemLiveData.observe(
            viewLifecycleOwner, { galleryItems ->
                Log.d(TAG, "Have gallery items from ViewModel $galleryItems")
                photoRecyclerView.adapter = MovieAdapter(galleryItems) {
                    Log.d(TAG, "Clicked event $it")
                    startDetailActivity(view.context, it)
                }
            }
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    fun startDetailActivity(context: Context, movie: ImdbMovie) {
        val showPhotoIntent = Intent(context, MovieDetailActivity::class.java)
        showPhotoIntent.putExtra(PHOTO_KEY, movie)
        context.startActivity(showPhotoIntent)
    }
}