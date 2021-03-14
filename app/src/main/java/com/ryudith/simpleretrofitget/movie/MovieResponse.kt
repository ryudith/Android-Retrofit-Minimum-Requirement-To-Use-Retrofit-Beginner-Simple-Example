package com.ryudith.simpleretrofitget.movie

data class MovieResponse (
    val code : Int,
    val message : String,
    val data : List<Movie>
)