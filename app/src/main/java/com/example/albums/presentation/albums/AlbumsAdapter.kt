package com.example.albums.presentation.albums

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.albums.R
import com.example.albums.domain.entities.Album

class AlbumsAdapter (context: Context, private var listener: Listener) : RecyclerView.Adapter<AlbumsAdapter.Holder>() {

    private val albums = ArrayList<Album>()
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemView = layoutInflater.inflate(R.layout.album_item, parent, false)
        return Holder(itemView, listener)
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(albums[position])
    }

    fun setAlbums(albums: List<Album>) {
        this.albums.clear()
        this.albums.addAll(albums)
        notifyDataSetChanged()
    }

    fun getAlbums(): List<Album> {
        return this.albums
    }

    inner class Holder(item: View, private val listener: Listener):
        RecyclerView.ViewHolder(item) {

        //private val title: TextView = item.findViewById(R.id.title)

        fun bind(album: Album) {
            itemView.setOnClickListener {
                listener.onSelect(album)
            }
        }
    }

    interface Listener {
        fun onSelect(album: Album)
    }
}