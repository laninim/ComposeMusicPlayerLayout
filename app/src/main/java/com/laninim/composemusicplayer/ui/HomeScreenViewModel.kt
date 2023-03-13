package com.laninim.composemusicplayer.ui

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel

class HomeScreenViewModel : ViewModel() {

    private var _recentlyPlayedVisible = mutableStateOf(true)
    val recentlyPlayedVisible : State<Boolean>  = _recentlyPlayedVisible

    fun expandRaccomandationAlbum(){
        _recentlyPlayedVisible.value = if(recentlyPlayedVisible.value) false else true

    }
}