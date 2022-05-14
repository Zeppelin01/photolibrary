package com.bignerdranch.android.photogallery

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bignerdranch.android.photogallery.moviedetail.MovieDetailFragment
import com.bignerdranch.android.photogallery.moviedetail.PHOTO_KEY

private const val TAG = "PhotoGalleryActivity"
const val MOVIE_ID = "com.android.photogallery.movie_id"

class PhotoGalleryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_gallery)

        var photoGalleryFragment = PhotoGalleryFragment.newInstance()

        if (Intent.ACTION_SEARCH == intent.action) {
            val title = intent.getStringExtra(SearchManager.QUERY)
            val bundle = Bundle()
            bundle.putString(MOVIE_ID, title)
            photoGalleryFragment.arguments = bundle
        }

        val isFragmentContainerEmpty = savedInstanceState == null
        if (isFragmentContainerEmpty) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, photoGalleryFragment)
                .commit()
        }
    }
}