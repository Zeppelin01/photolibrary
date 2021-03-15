package com.bignerdranch.android.photogallery.api

import com.google.gson.annotations.SerializedName

class ImdbRating {
    @SerializedName("Source")
    var source: String? = null

    @SerializedName("Value")
    var value: String? = null
}