package com.rockmelon.app.di


import com.rockmelon.app.service.MovieRepository
import com.rockmelon.app.viewmodel.MovieListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = arrayOf(ServiceModule::class))
interface AppComponent {

    fun inject(vm: MovieListViewModel)
    fun inject(repository: MovieRepository)
}