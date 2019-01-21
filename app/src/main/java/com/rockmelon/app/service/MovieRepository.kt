package com.rockmelon.app.service


import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.rockmelon.app.MovieApp
import com.rockmelon.app.R
import com.rockmelon.app.service.model.ApiResponse
import com.rockmelon.app.service.model.MoviesItem

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor() {

    private val TAG = MovieRepository::class.java.name

    @Inject
    lateinit var movieApi:MovieApi

    init {
        MovieApp.get().component.inject(this)
    }

    fun getMovies(): LiveData<Resource<List<MoviesItem?>>> {
        val data = MutableLiveData<Resource<List<MoviesItem?>>>()

        movieApi.getMovieDetails().enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    data.setValue(Resource.success(apiResponse.data!!.movies!!))
                } else {
                    handleFailure(data, response.message())
                    response.errorBody()?.close()
                }
            }
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e(TAG, t.stackTrace.toString())
                handleFailure(data, MovieApp.get().getString(R.string.network_error))
            }
        })
        return data
    }

    private fun handleFailure(liveData: MutableLiveData<*>, msg: String) {
        liveData.value = Resource.error<Any>(msg, null)
    }
}