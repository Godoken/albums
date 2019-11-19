package com.example.albums.presentation.albums

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.albums.domain.entities.Album
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class AlbumsViewModel: ViewModel() {

    private var disposable: CompositeDisposable? = null

    private lateinit var albums: MutableLiveData<List<Album>>
    private lateinit var progress: MutableLiveData<String>

    fun loadAlbums(): MutableLiveData<List<Album>> {
        albums = MutableLiveData()
        val observable: Observable<List<Album>> = useCase.loadAlbums()
            observable
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { progress.postValue("onSubscribe") }
                .doOnComplete { progress.postValue("onComplete") }
                .subscribe (
                    {result: List<Album>? ->
                        albums.postValue(result)
                    },
                    {e: Throwable? ->
                        progress.postValue("onError")
                    }
                )?.let {
                    getCompositeDisposable()?.add(it)
                }
        return albums
    }

    fun getProgress(): MutableLiveData<String> {
        progress = MutableLiveData()
        return progress
    }

    private fun getCompositeDisposable(): CompositeDisposable? {
        if (disposable == null) disposable = CompositeDisposable()
        return disposable
    }
}