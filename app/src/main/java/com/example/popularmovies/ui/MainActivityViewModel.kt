package com.example.popularmovies.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.popularmovies.api.MovieRepository
import com.example.popularmovies.model.MovieList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val movieRepository = MovieRepository(application.applicationContext)
    val moviesList = MutableLiveData<MovieList>()
    val error = MutableLiveData<String>()

    fun getMovies(year: String) {
        movieRepository.getMovies(year).enqueue(object : Callback<MovieList> {
            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                error.value = t.message
            }

            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                if (response.isSuccessful) {
                    moviesList.value = response.body()
                } else error.value = "An error occurred: ${response.errorBody().toString()}"
            }
        })
    }
}