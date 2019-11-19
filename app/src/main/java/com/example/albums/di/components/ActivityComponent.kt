package com.example.albums.di.components

import com.example.albums.di.PerActivity
import com.example.albums.di.components.albums.AlbumsComponent
import com.example.albums.di.components.geolocation.GeolocationComponent
import com.example.albums.di.modules.ActivityModule
import com.example.albums.di.modules.albums.AlbumsModule
import com.example.albums.di.modules.geolocation.GeolocationModule
import dagger.Component

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    //fun inject(splashActivity: SplashActivity)

    fun provideAlbumsModule(module: AlbumsModule): AlbumsComponent
    fun provideGeolocationModule(module: GeolocationModule): GeolocationComponent
}