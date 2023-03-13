package com.laninim.composemusicplayer.ui

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.laninim.composemusicplayer.data.DataSource
import com.laninim.composemusicplayer.domain.Album
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeScreenViewModel : ViewModel(
) {

    private var _recentlyPlayedVisible = mutableStateOf(true)
    val recentlyPlayedVisible : State<Boolean>  = _recentlyPlayedVisible

    private var _recentlyPlayedSong : List<Album>? = DataSource.getAlbumList()
    val recentlyPlayedSong = _recentlyPlayedSong





    private var _recommendandAlbum : List<Album>? = DataSource.getAlbumList()
    val recomendandAlbum = _recommendandAlbum



    fun expandRaccomandationAlbum(){
        _recentlyPlayedVisible.value = if(recentlyPlayedVisible.value) false else true
    }




}