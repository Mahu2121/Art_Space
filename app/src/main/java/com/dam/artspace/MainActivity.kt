package com.dam.artspace


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dam.artspace.ui.theme.ArtSpaceTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceScreen(artworks = artworks)
            }
        }
    }
}

@Composable
fun ArtSpaceScreen(artworks: List<Artwork>) {
    var currentIndex by remember { mutableStateOf(0) }
    val artwork = artworks[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Image(
            painter = painterResource(id = artwork.imageResId),
            contentDescription = artwork.title,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(8.dp)
        )

        Text(text = artwork.title)
        Text(text = "${artwork.artist}, ${artwork.year}")


        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = {
                currentIndex = if (currentIndex > 0) currentIndex - 1 else artworks.lastIndex
            }) {
                Text("Anterior")
            }
            Button(onClick = {
                currentIndex = if (currentIndex < artworks.lastIndex) currentIndex + 1 else 0
            }) {
                Text("Siguiente")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceScreen(artworks)
    }
}

