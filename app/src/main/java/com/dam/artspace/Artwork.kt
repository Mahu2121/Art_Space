package com.dam.artspace

data class Artwork(val imageResId: Int,
              val title: String,
              val artist: String,
              val year: Int) {

}
    val artworks = listOf(
        Artwork(R.drawable.gato1, "La Mona Lisa", "Leonardo da Vinc", 1506),
        Artwork(R.drawable.gato2, "La noche estrellada", "Vincent van Gogh", 1889),
        Artwork(R.drawable.gato3, "Guernica", "Pablo Picasso", 1937),
        Artwork(R.drawable.gato4, "Impresión, sol naciente", "Claude Monet", 1872)
    )

