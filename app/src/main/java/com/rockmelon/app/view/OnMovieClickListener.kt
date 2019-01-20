package com.rockmelon.app.view

import com.rockmelon.app.service.model.MoviesItem

interface OnMovieClickListener {
    fun onMovieClick(moviesItem: MoviesItem?)
}