package com.example.popularmovies.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.popularmovies.R
import com.example.popularmovies.model.Movie
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_main.toolbar

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initViews()
    }

    private fun initViews() {
        val movie: Movie = intent.extras?.getParcelable(EXTRA_MOVIE)!!

        tvTitle.text = movie.title
        Glide.with(this).load(movie.getPosterUrl()).into(ivPoster)
        Glide.with(this).load(movie.getBackdropUrl()).into(ivBackdrop)
        tvReleaseDate.text = String.format(getString(R.string.release_date), movie.releaseDate)
        tvRating.text = movie.rating.toString()
        tvOverview.text = movie.overview
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
