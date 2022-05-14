package com.bignerdranch.android.photogallery.search

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.photogallery.R

private val PHOTO_KEY = "com.android.photogallery.movie_data"

class MovieViewHolder(var view: View): RecyclerView.ViewHolder(view) /*, View.OnClickListener*/ {

    var movieTitle: TextView = view.findViewById(R.id.movie_title)
    var poster: ImageView = view.findViewById(R.id.detail_poster)

    init {
//        view.setOnClickListener(this)
    }

//    override fun onClick(v: View?) {
//        val context = itemView.context
//        val showPhotoIntent = Intent(context, MovieDetailActivity::class.java)
//
//        val movie = ImdbMovie()
//        movie.title = movieTitle.text.toString()
//        showPhotoIntent.putExtra(PHOTO_KEY, movie)
//        context.startActivity(showPhotoIntent)
//    }
}
