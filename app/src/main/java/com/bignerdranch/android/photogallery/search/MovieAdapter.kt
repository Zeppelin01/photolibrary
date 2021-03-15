package com.bignerdranch.android.photogallery.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.photogallery.R
import com.bignerdranch.android.photogallery.api.ImdbMovie
import com.squareup.picasso.Picasso

class MovieAdapter(val myModel: List<ImdbMovie>, private val mListener: (ImdbMovie) -> Unit) : RecyclerView.Adapter<MovieViewHolder>()
{
    val picasso = Picasso.get()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val myView = inflater.inflate(R.layout.search_result_item_layout, parent, false)

        return MovieViewHolder(myView)
    }

    override fun onBindViewHolder(viewHolder: MovieViewHolder, position: Int) {
        val contact: ImdbMovie = myModel.get(position)

        val movieTitle = viewHolder.movieTitle
        movieTitle.setText(contact.title)

        val poster = viewHolder.poster
        picasso.load(contact.poster).into(poster)

        viewHolder.itemView.setOnClickListener{
            contact.let {
                    movie -> mListener.invoke(movie)
            }
        }
    }

    override fun getItemCount(): Int {
        return myModel.size
    }
}

