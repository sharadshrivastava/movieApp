package com.rockmelon.app.view.adapter

import com.rockmelon.app.service.model.MoviesItem

interface OnMovieClickListener {
    fun onMovieClick(moviesItem: MoviesItem?)
}