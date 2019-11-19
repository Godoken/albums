package com.example.albums.di.components

import android.content.Context
import com.example.albums.di.modules.ApiModule
import com.example.albums.di.modules.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ApiModule::class])
interface ApplicationComponent {

    fun provideAppContext(): Context

    //fun provideCiceroneHolder(): LocalCiceroneHolder
}