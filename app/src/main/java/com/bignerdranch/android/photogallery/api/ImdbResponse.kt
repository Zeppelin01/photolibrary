package com.bignerdranch.android.photogallery.api

import com.google.gson.annotations.SerializedName

class ImdbResponse {
    @SerializedName("Search")
    var search: List<ImdbMovie>? = null

    @SerializedName("totalResults")
    var totalResults: String? = null

    @SerializedName("Response")
    var response: String? = null
}