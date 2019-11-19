package com.example.albums.di.components.albums

import com.example.albums.di.modules.albums.AlbumsModule
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [AlbumsModule::class])
interface AlbumsComponent {
    //fun inject(albumsFragment: AlbumsFragment)
    //fun inject(albumsActivity: AlbumsActivity)

    //fun inject(detailAlbumActivity: DetailAlbumActivity)
    //fun inject(detailAlbumFragment: DetailAlbumFragment)
}