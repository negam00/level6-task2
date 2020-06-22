package com.example.popularmovies.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Movie (
    @SerializedName("title") var title: String,
    @SerializedName("poster_path") var posterImage: String,
    @SerializedName("backdrop_path") var backdropImage: String,
    @SerializedName("release_date") var releaseDate: Date,
    @SerializedName("vote_average") var rating: Double,
    @SerializedName("overview") var overview: String
) :Parcelable {
    fun getBackdropUrl() = "https://image.tmdb.org/t/p/w500/$backdropImage"
    fun getPosterUrl() = "https://image.tmdb.org/t/p/w185/$posterImage"
}