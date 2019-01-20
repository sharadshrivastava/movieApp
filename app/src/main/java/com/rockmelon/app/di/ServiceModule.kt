package com.rockmelon.app.di

import com.rockmelon.app.service.MockInterceptor
import com.rockmelon.app.service.MovieApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun getRetrofit():Retrofit = Retrofit.Builder()
        .baseUrl(MovieApi.BASE_URL)
        .client(getClient())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun getApi(retrofit:Retrofit):MovieApi = retrofit.create(MovieApi::class.java);

    @Provides
    @Singleton
    fun getClient(): OkHttpClient =  OkHttpClient.Builder().
        addInterceptor(MockInterceptor()).build()

}