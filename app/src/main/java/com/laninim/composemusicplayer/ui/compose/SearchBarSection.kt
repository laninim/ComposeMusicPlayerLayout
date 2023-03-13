package com.laninim.composemusicplayer.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.laninim.composemusicplayer.ui.theme.Purple600


@Composable
fun SearchBarComponent(
    modifier : Modifier = Modifier
) {
    var textfieldValue = remember { mutableStateOf("") }

    TextField(
        value = textfieldValue.value ,
        onValueChange = {
                        textfieldValue.value = it
        },
        placeholder = {Text("Search song", color = Color.White, modifier = Modifier.alpha(0.8f), textAlign = TextAlign.Start)},
        modifier = modifier
            .background(shape = RoundedCornerShape(10.dp), color = Purple600),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search , contentDescription = null, tint = Color.White )
        },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            // Indicators for textfield color
        )


    )
}


@Preview
@Composable
fun SearchBarPreview() {
    SearchBarComponent()
}