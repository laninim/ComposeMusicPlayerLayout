package com.laninim.composemusicplayer.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.laninim.composemusicplayer.ui.compose.ReccomandationSection
import com.laninim.composemusicplayer.ui.compose.RecentlyPlayedSection
import com.laninim.composemusicplayer.ui.compose.SearchBarComponent
import com.laninim.composemusicplayer.ui.theme.Purple600
import com.laninim.composemusicplayer.ui.theme.Purple700

@Composable
fun HomeScreen(){
    val viewModel : HomeScreenViewModel = viewModel()
    var showAll = remember {
        mutableStateOf(viewModel.recentlyPlayedVisible)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Purple700 , Purple600) ,
                    start = Offset(50f , 50f) ,
                    end = Offset.Infinite
                )
            ),

    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            if(showAll.value.value){
            SearchBarComponent(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))


            RecentlyPlayedSection(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

            Spacer(modifier = Modifier.height(36.dp))
            ReccomandationSection()
        }

    }
}