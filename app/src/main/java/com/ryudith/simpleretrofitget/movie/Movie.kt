package com.ryudith.simpleretrofitget.movie

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("movie_id")
    var id : Long,
    var name : String,
    var year : Int
)
