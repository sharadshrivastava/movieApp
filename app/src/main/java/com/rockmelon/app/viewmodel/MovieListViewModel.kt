package com.rockmelon.app.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.databinding.ObservableField
import com.rockmelon.app.MovieApp
import com.rockmelon.app.service.MovieRepository
import com.rockmelon.app.service.Resource
import com.rockmelon.app.service.model.MoviesItem


import javax.inject.Inject

class MovieListViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var movieRepository: MovieRepository

    init {
        MovieApp.get().component.inject(this)
    }

    fun getMovies(): LiveData<Resource<List<MoviesItem?>>> = movieRepository.getMovies()

}