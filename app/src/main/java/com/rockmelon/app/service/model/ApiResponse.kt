package com.rockmelon.app.service.model

import com.squareup.moshi.Json

data class ApiResponse(

	@Json(name="data")
	val data: Data? = null
)