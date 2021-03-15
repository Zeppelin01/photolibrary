package com.bignerdranch.android.photogallery.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ImdbMovie : Serializable {
    @SerializedName("Title")
    var title: String? = null

    @SerializedName("Year")
    var year: String? = null
    var imdbID: String? = null

    @SerializedName("Type")
    var type: String? = null

    @SerializedName("Poster")
    var poster: String? = null
}