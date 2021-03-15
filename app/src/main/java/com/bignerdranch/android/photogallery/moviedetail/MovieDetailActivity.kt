package com.bignerdranch.android.photogallery.moviedetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bignerdranch.android.photogallery.R
import com.bignerdranch.android.photogallery.api.ImdbMovie

val PHOTO_KEY = "com.android.photogallery.movie_data"

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_detail_activity)

        val movie: ImdbMovie? = intent.getSerializableExtra(PHOTO_KEY) as? ImdbMovie
        var movieDetailFragment = MovieDetailFragment.newInstance()

        val bundle = Bundle()
        bundle.putSerializable(PHOTO_KEY, movie)

        movieDetailFragment.arguments = bundle

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, movieDetailFragment)
                .commitNow()
        }
    }
}