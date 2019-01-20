package com.rockmelon.app

import android.app.Application
import com.rockmelon.app.di.AppComponent
import com.rockmelon.app.di.DaggerAppComponent
import com.rockmelon.app.di.ServiceModule


class MovieApp : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        component = DaggerAppComponent.builder().
                serviceModule(ServiceModule()).build()
    }

    companion object {
        private var instance:MovieApp? = null
        fun get():MovieApp = instance!!
    }
}