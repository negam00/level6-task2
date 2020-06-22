package com.example.popularmovies.api

import android.content.Context

class MovieRepository (context: Context) {
    private val moviesApiService: MovieApiService = MoviesApi.createApi()

    fun getMovies(year: Int) = moviesApiService.getMovies(year)
}