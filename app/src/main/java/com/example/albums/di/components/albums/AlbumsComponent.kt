package com.example.albums.di.components.albums

import com.example.albums.di.modules.albums.AlbumsModule
import com.example.albums.presentation.albums.AlbumsActivity
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [AlbumsModule::class])
interface AlbumsComponent {
    fun inject(albumsActivity: AlbumsActivity)

    //fun inject(detailAlbumActivity: DetailAlbumActivity)
}