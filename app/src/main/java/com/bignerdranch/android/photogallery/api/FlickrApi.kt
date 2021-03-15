package com.bignerdranch.android.photogallery.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApi {

    @GET("/")
    fun fetchContents(): Call<String>

    @GET("/")
    fun fetchMoviesByTitle(
        @Query("s") title: String,
        @Query("apikey") apiKey:String): Call<ImdbResponse>

    @GET("/")
    fun fetchMoviesById(
        @Query("i") id: String,
        @Query("apikey") apiKey:String): Call<ImdbMovieDetail>
}