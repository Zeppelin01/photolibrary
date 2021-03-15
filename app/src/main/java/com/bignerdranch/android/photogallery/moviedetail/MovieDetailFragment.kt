package com.bignerdranch.android.photogallery.moviedetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bignerdranch.android.photogallery.R
import com.bignerdranch.android.photogallery.api.ImdbMovie
import com.bignerdranch.android.photogallery.api.ImdbMovieDetail
import com.bignerdranch.android.photogallery.databinding.MovieDetailFragmentBinding
import com.squareup.picasso.Picasso

class MovieDetailFragment : Fragment() {

    lateinit var imdbMovie: ImdbMovie
    private var _binding: MovieDetailFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MovieDetailFragment()
    }

    private lateinit var viewModel: MovieDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MovieDetailFragmentBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.movieItemLiveData.observe(viewLifecycleOwner, {
            updateUI(it)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imdbMovie = (arguments!!.getSerializable(PHOTO_KEY)) as ImdbMovie
        viewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)

        viewModel.searchMovieDetail(imdbMovie.imdbID!!)
    }

    fun updateUI(imdbMovieDetail: ImdbMovieDetail) {
        Picasso.get().load(imdbMovieDetail.poster).resize(1000, 1000).into(binding.detailPoster)

        binding.movieDetailTitle.text = String.format("%s (%s)",
            imdbMovieDetail.title,
            imdbMovieDetail.year
        )
        binding.movieDetailSummary.text = String.format("%s %s\n%s %s",
            context!!.getString(R.string.movie_director),
            imdbMovieDetail.director,
            context!!.getString(R.string.movie_plot),
            imdbMovieDetail.plot
        )
    }
}