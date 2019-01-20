package com.rockmelon.app.service

import com.rockmelon.app.service.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {

    @GET(MOVIE_PATH)
    fun getMovieDetails(): Call<ApiResponse>

    companion object {
        const val BASE_URL = "https://www.rockmelon.com"
        const val MOVIE_PATH = "/movies"
    }
}