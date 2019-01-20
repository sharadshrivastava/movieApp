package com.rockmelon.app.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.rockmelon.app.service.model.MoviesItem


class MovieDetailsViewModel(application: Application) : AndroidViewModel(application) {

    private var movieItem: MoviesItem? = null

    constructor(app: Application, item: MoviesItem?) : this(app) {
        movieItem = item
    }


    class MovieDetailsViewModelFactory(private val mApplication: Application, private val item: MoviesItem?) :
        ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MovieDetailsViewModel(mApplication, item) as T
        }
    }

}