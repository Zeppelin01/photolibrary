package com.bignerdranch.android.photogallery.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.photogallery.api.ImdbMovieFetchr
import com.bignerdranch.android.photogallery.api.ImdbMovieDetail

class MovieDetailViewModel : ViewModel() {

    lateinit var movieItemLiveData: LiveData<ImdbMovieDetail>

    fun searchMovieDetail(id: String) {
        movieItemLiveData = ImdbMovieFetchr().fetchMovieById(id)
    }
}