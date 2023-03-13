package com.laninim.composemusicplayer.domain

data class Album(
    val albumName : String,
    val songs : List<Song>,
    val author : String,
    val image : Int,
    var favorite : Boolean = false
) {

}