package com.example.albums.di.components.geolocation

import com.example.albums.di.modules.geolocation.GeolocationModule
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [GeolocationModule::class])
interface GeolocationComponent {
    //fun inject(geolocationActivity: GeolocationActivity)
}