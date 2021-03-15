package com.bignerdranch.android.photogallery.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "ImdbMovieFetchr"

class ImdbMovieFetchr {

    private val flickrApi: FlickrApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://www.omdbapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        flickrApi = retrofit.create(FlickrApi::class.java)
    }

    fun fetchContents(): LiveData<String> {
        val responseLiveData: MutableLiveData<String> = MutableLiveData()
        val flickrRequest: Call<String> = flickrApi.fetchContents()

        flickrRequest.enqueue(object : Callback<String> {

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e(TAG, "Failed to fetch photos", t)
            }

            override fun onResponse(
                call: Call<String>,
                response: Response<String>
            ) {
                Log.d(TAG, "Response received")
                responseLiveData.value = response.body()
            }
        })

        return responseLiveData
    }

    fun fetchMovies(title: String): LiveData<List<ImdbMovie>> {
        val responseLiveData: MutableLiveData<List<ImdbMovie>> = MutableLiveData()
        //TODO: Manage keys in a secure way
        val flickrRequest: Call<ImdbResponse> = flickrApi.fetchMoviesByTitle(title, "e368b402")

        flickrRequest.enqueue(object : Callback<ImdbResponse> {

            override fun onFailure(call: Call<ImdbResponse>, t: Throwable) {
                Log.e(TAG, "Failed to fetch photos", t)
            }

            override fun onResponse(
                call: Call<ImdbResponse>,
                response: Response<ImdbResponse>
            ) {
                Log.d(TAG, "Response received")
                val imdbResponse: ImdbResponse? = response.body()
                var movieItems: List<ImdbMovie> = imdbResponse?.search ?: mutableListOf()
                movieItems = movieItems.filterNot {it.poster!!.isBlank() || it.poster!!.equals("N/A")}
                responseLiveData.value = movieItems
            }
        })

        return responseLiveData
    }

    fun fetchMovieById(id: String): LiveData<ImdbMovieDetail> {
        val responseLiveData: MutableLiveData<ImdbMovieDetail> = MutableLiveData()
        //TODO: Manage keys in a secure way
        val flickrRequest: Call<ImdbMovieDetail> = flickrApi.fetchMoviesById(id, "e368b402")

        flickrRequest.enqueue(object : Callback<ImdbMovieDetail> {

            override fun onFailure(call: Call<ImdbMovieDetail>, t: Throwable) {
                Log.e(TAG, "Failed to fetch photos", t)
            }

            override fun onResponse(
                call: Call<ImdbMovieDetail>,
                response: Response<ImdbMovieDetail>
            ) {
                Log.d(TAG, "Response received")
                val imdbMovieDetail: ImdbMovieDetail? = response.body()
//                val photoResponse: ImdbResponse? = imdbResponse?.search
//                var movieItems: List<ImdbMovie> = imdbMovieDetail? ?: mutableListOf()
//                movieItems = movieItems.filterNot {it.poster!!.isBlank() || it.poster!!.equals("N/A")}
                responseLiveData.value = imdbMovieDetail
            }
        })

        return responseLiveData
    }
}