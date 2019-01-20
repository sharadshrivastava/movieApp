package com.rockmelon.app.service

import com.rockmelon.app.MovieApp
import com.rockmelon.app.service.MovieApi.Companion.MOVIE_PATH
import okhttp3.*

class MockInterceptor:Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var path  = chain.request().url().uri().path
        var response:String? = null
        if(path == MOVIE_PATH){
            response = getResponseData()
        }
        return getResponse(chain.request(), response)
    }

    private fun getResponse(request: Request,response:String?):Response{
        return Response.Builder().code(200).message(response).request(request)
            .protocol(Protocol.HTTP_1_0)
            .body(ResponseBody.create(MediaType.parse("application/json"), response?.toByteArray()))
            .addHeader("content-type", "application/json")
            .build()
    }

    private fun getResponseData():String{
        var input = MovieApp.get().assets.open("data.json")
        return input.bufferedReader().use { it.readText() }
    }
}