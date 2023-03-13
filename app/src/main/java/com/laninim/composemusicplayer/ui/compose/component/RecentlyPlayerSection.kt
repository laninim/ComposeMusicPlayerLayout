package com.laninim.composemusicplayer.ui.compose

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.laninim.composemusicplayer.data.DataSource
import com.laninim.composemusicplayer.domain.Album
import com.laninim.composemusicplayer.ui.HomeScreenViewModel


@Composable
fun RecentlyPlayedSection(
    modifier: Modifier = Modifier
) {
    val viewmodel : HomeScreenViewModel = viewModel()

    Column(
        modifier = modifier
    ) {
        Row(modifier = Modifier.fillMaxWidth() , horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "RECENTLY PLAYED" ,
                color = Color.White
            )

            Text(

                text = "See all" ,
                modifier = Modifier
                    .alpha(0.6f)
                    .clickable {
                        viewmodel.expandRaccomandationAlbum()
                    },
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        LazyRow(
            contentPadding = PaddingValues(8.dp)
        ){
            items(viewmodel.recentlyPlayedSong!!){
                AlbumSection(
                    album = it
                )
            }
        }
    }
}

@Composable
fun AlbumSection(
    modifier: Modifier = Modifier ,
    album : Album
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(album.image) ,
            contentDescription = "${album.albumName}" ,
            contentScale = ContentScale.Fit ,
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .size(150.dp)
        )
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            text = album.albumName ,
            color = Color.White
        )
        Text(
            text = album.author ,
            color = Color.White ,
            modifier = Modifier.alpha(0.6f)
        )
    }
}


@Preview
@Composable
fun PreviewRecentlyPlayed() {
    RecentlyPlayedSection()
}