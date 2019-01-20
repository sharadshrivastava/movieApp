package com.rockmelon.app.service.model

import com.squareup.moshi.Json

data class MoviesItem(

	@Json(name="Writers")
	val writers: List<String?>? = null,

	@Json(name="Stars")
	val stars: String? = null,

	@Json(name="Plot")
	val plot: String? = null,

	@Json(name="Rating")
	val rating: String? = null,

	@Json(name="Director")
	val director: String? = null,

	@Json(name="Title")
	val title: String? = null,

	@Json(name="Actors")
	val actors: List<String?>? = null,

	@Json(name="Studio")
	val studio: String? = null,

	@Json(name="Copyright")
	val copyright: String? = null,

	@Json(name="Runtime")
	val runtime: String? = null,

	@Json(name="Year")
	val year: String? = null,

	@Json(name="Poster")
	val poster: String? = null,

	@Json(name="Votes")
	val votes: String? = null,

	@Json(name="Genre")
	val genre: String? = null
)