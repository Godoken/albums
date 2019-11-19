package com.example.albums.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule (private val mApplication: Application) {

    val applicationContext: Context
        @Provides
        @Singleton
        get() = mApplication.applicationContext

    /*@Provides
    @Singleton
    fun provideCiceroneHolder(): LocalCiceroneHolder = LocalCiceroneHolder()*/
}