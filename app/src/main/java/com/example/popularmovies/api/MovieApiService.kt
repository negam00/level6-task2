package com.example.popularmovies.api

import com.example.popularmovies.model.MovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("/3/discover/movie?api_key=bef18c554c5f2af67d2c9f416bd9ed09&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
    fun getMovies(@Query("year") year: String): Call<MovieList>
}