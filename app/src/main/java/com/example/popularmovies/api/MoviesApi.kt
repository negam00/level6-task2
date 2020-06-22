package com.example.popularmovies.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesApi {
    companion object {

        private const val baseUrl = "https://api.themoviedb.org"

        /**
         * @return [MovieApiService] The service class off the retrofit client.
         */
        fun createApi(): MovieApiService {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            // retrofit instance
            val movieApi = Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create()).build()

            // return retrofit Nu,bersApiService
            return movieApi.create(MovieApiService::class.java)
        }
    }
}