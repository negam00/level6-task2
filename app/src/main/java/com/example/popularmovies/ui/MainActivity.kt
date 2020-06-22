package com.example.popularmovies.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.popularmovies.R
import com.example.popularmovies.model.Movie
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

const val EXTRA_MOVIE = "EXTRA_MOVIE"
class MainActivity : AppCompatActivity() {
    private val movies = arrayListOf<Movie>()
    private val movieAdapter = MovieAdapter(movies) { movie -> onMovieItemClick(movie) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initViews()
    }

    private fun initViews() {
        val gridLayoutManager = GridLayoutManager(this, 1, RecyclerView.VERTICAL, false)
        rvMovies.layoutManager = gridLayoutManager
        rvMovies.adapter = movieAdapter

        btnMovieYear.setOnClickListener { onSumbitClick() }
    }

    private fun onSumbitClick() {

    }

    private fun onMovieItemClick(movie: Movie) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(EXTRA_MOVIE, movie)
        startActivityForResult(intent, 100)
    }
}
