package com.laninim.composemusicplayer.ui.compose

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.laninim.composemusicplayer.R
import com.laninim.composemusicplayer.data.DataSource
import com.laninim.composemusicplayer.ui.HomeScreenViewModel

@Composable
fun ReccomandationSection(
    modifier: Modifier = Modifier
){
    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        Row(modifier = Modifier.fillMaxWidth() , horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "RECOMMENDATION" ,
                color = Color.White
            )
            val viewModel : HomeScreenViewModel = viewModel()
            Text(

                text = if(viewModel.recentlyPlayedVisible.value) "See all" else "close",
                modifier = Modifier
                    .alpha(0.6f)
                    .clickable {
                        viewModel.expandRaccomandationAlbum()
                        Log.d("ViewModel","expand raccomandation section")
                    } ,
                color = Color.White ,

                )
        }
        LazyColumn(contentPadding = PaddingValues(18.dp )){
            items(DataSource.getAlbumList()){
                AlbumRowSection(
                    image = it.image  ,
                    albumName = it.albumName,
                    author = it.author )
                Spacer(modifier = Modifier.height(6.dp))
            }
        }
    }
}

@Composable
fun AlbumRowSection(
    modifier: Modifier = Modifier,
    @DrawableRes image : Int,
    albumName : String,
    author : String

){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(70.dp), verticalAlignment = Alignment.CenterVertically) {
        Row(modifier = Modifier.padding(4.dp)) {
            Image(
                painter = painterResource(id = image) ,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(50.dp)
            )
        }
        Spacer(modifier = Modifier.width(4.dp))
        Column(
            modifier= Modifier
                .fillMaxHeight()
                .weight(3f),
            verticalArrangement = Arrangement.Center,

        ) {
            Text(
                text = albumName,
                fontSize = 20.sp,
                color = Color.White
            )
            Text(
                text = author,
                color = Color.White,
                modifier = Modifier
                    .alpha(0.6f)
            )
        }
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.wrapContentSize()
        ) {

            Icon(
                imageVector = Icons.Outlined.Favorite,
                contentDescription = null,
                tint = Color.White,
            )
        }
    }

}

@Preview
@Composable
fun PreviewRowAlbum(){
    AlbumRowSection(
        image = R.drawable.bustaalbum,
        albumName = "Great Hits",
        author = "2Pac",

    )

}

@Preview
@Composable
fun PreviewRaccomandationSection(){
    ReccomandationSection()
}