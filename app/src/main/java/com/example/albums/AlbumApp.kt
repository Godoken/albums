package com.example.albums

import android.annotation.SuppressLint
import android.app.Application
import com.example.albums.di.components.ApplicationComponent
import com.example.albums.di.components.DaggerApplicationComponent
import com.example.albums.di.modules.ApiModule
import com.example.albums.di.modules.ApplicationModule

class AlbumApp: Application() {

    companion object {
        private var appContext: AlbumApp? = null
        fun getAppContext(): AlbumApp? {
            return appContext
        }

        lateinit var appComponent: ApplicationComponent
            private set
    }

    @SuppressLint("CheckResult")
    override fun onCreate() {
        super.onCreate()
        val module = ApplicationModule(this)
        val apiModule = ApiModule()
        appComponent = DaggerApplicationComponent.builder()
            .apiModule(apiModule)
            .applicationModule(module)
            .build()
    }
}