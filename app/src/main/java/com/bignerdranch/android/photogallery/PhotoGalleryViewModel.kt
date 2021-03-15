package com.bignerdranch.android.photogallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.photogallery.api.ImdbMovieFetchr
import com.bignerdranch.android.photogallery.api.ImdbMovie

class PhotoGalleryViewModel : ViewModel() {

    lateinit var movieItemLiveData: LiveData<List<ImdbMovie>>

    fun fetchMovies(title: String) {
        movieItemLiveData = ImdbMovieFetchr().fetchMovies(title)
    }
}