package com.laninim.composemusicplayer.data

import com.laninim.composemusicplayer.R
import com.laninim.composemusicplayer.domain.Album

object DataSource {

    val album : List<Album> = mutableListOf(
        Album("Great Hits", listOf(), "2Pac", R.drawable.tupacalbum),
        Album("BustaTime", listOf(),"BusthaRymhes", R.drawable.bustaalbum),
        Album("BiggieKing", listOf(), "Biggie Small", R.drawable.biggiesmallalbum),
        Album("Blood of the dance floor", listOf(),"Michael Jackson", R.drawable.bloodofthedancefloor),
        Album("Get your wings", listOf(), "Aerosmith", R.drawable.aerosmith)
    )

    fun getAlbumList() : List<Album> {
        return album
    }
}