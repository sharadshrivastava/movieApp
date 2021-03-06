package com.rockmelon.app.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.rockmelon.app.MovieApp
import com.rockmelon.app.R
import com.rockmelon.app.service.MovieRepository
import com.rockmelon.app.service.Resource
import com.rockmelon.app.service.model.MoviesItem
import com.rockmelon.app.utils.Utils
import com.rockmelon.app.view.adapter.HorizontalSpaceItemDecoration
import com.rockmelon.app.view.adapter.MoviesAdapter


import javax.inject.Inject

class MovieListViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var movieRepository: MovieRepository

    init {
        MovieApp.get().component.inject(this)
    }

    fun getMovies(): LiveData<Resource<List<MoviesItem?>>> = movieRepository.getMovies()

}