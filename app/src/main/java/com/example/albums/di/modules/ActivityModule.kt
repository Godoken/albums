package com.example.albums.di.modules

import android.app.Activity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
    @get:Provides val actvity: Activity
)