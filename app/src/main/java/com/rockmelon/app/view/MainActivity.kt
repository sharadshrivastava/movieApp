package com.rockmelon.app.view

import android.os.Bundle
import com.rockmelon.app.R
import com.rockmelon.app.service.model.MoviesItem


class MainActivity : BaseActivity(), OnMovieClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        var fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (fragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, MovieListFragment.create())
                .commit()
        }
    }

    private fun launchMovieDetails(moviesItem: MoviesItem?){
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, MovieDetailsFragment.create(moviesItem))
            .addToBackStack(null)
            .commit()
    }

    override fun onMovieClick(moviesItem: MoviesItem?) {
        launchMovieDetails(moviesItem)
    }

}