package com.rockmelon.app.service.model

import com.squareup.moshi.Json

data class Data(

	@Json(name="movies")
	val movies: List<MoviesItem?>? = null
)