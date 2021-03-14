package com.ryudith.simpleretrofitget.movie

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieURL {
    @GET("method_get.php")
//    suspend fun listMovie(@Query("page") p : Int = 1) : Response<List<Movie>>
    suspend fun listMovie(@Query("page") p : Int = 1) : Response<MovieResponse>
}