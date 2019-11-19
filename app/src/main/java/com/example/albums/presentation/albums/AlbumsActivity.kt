package com.example.albums.presentation.albums

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.albums.AlbumApp
import com.example.albums.R
import com.example.albums.di.components.ActivityComponent
import com.example.albums.di.components.DaggerActivityComponent
import com.example.albums.di.modules.ActivityModule
import com.example.albums.di.modules.albums.AlbumsModule
import com.example.albums.domain.entities.Album
import kotlinx.android.synthetic.main.activity_albums.*

class AlbumsActivity : AppCompatActivity() {

    private lateinit var viewModel: AlbumsViewModel
    private lateinit var adapter: AlbumsAdapter
    lateinit var component: ActivityComponent

    fun injectDependencies(component: ActivityComponent) {
        component.provideAlbumsModule(AlbumsModule()).inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .applicationComponent(AlbumApp.appComponent)
            .build()
        injectDependencies(component)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)
        initView()
    }

    private fun initView() {
        viewModel = ViewModelProviders.of(this).get(AlbumsViewModel::class.java)

        viewModel.getProgress().observe(this, Observer {
            when (it) {
                "onSubscribe" -> {showProgress()}
                "onError" -> {
                    hideProgress()
                    showErrorMessage()}
                "onComplete" -> {hideProgress()}
            }
        })

        viewModel.loadAlbums().observe(this@AlbumsActivity, Observer {
            adapter.setAlbums(it)
        })

        adapter = AlbumsAdapter(this@AlbumsActivity, object : AlbumsAdapter.Listener {
            override fun onSelect(album: Album) {
                /*startActivity(Intent(this@MainActivity, DetailsActivity::class.java)
                    .putStringArrayListExtra("baseParameters", ArrayList(baseParameters)))*/
            }
        })
        albums_recycler_view.adapter = adapter
    }

    private fun showErrorMessage() {
        //val serverErrorFragment = ServerErrorFragment()
        //supportFragmentManager.beginTransaction().add(R.id.albums_fragment_container, serverErrorFragment).commit()
    }

    private fun showProgress() {
        //val progressFragment = ProgressFragment()
        //supportFragmentManager.beginTransaction().add(R.id.albums_fragment_container, progressFragment).commit()
    }

    private fun hideProgress() {
        //supportFragmentManager.findFragmentById(R.id.albums_fragment_container)?.let {
            //supportFragmentManager.beginTransaction().remove(it).commit()
        //}
    }
}