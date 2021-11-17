package cab.andrew.disneycodingchallenge.ui.dog_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cab.andrew.disneycodingchallenge.R
import cab.andrew.disneycodingchallenge.data.domain.DogImage
import coil.ImageLoader
import coil.compose.rememberImagePainter

@ExperimentalMaterialApi
@Composable
fun DogListItem(
    dog: DogImage,
    navigateToDogScreen: (dogId: Int) -> Unit,
    imageLoader: ImageLoader,
){

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(modifier = Modifier.height(230.dp)
            .fillMaxWidth(),
            onClick = {
                navigateToDogScreen( dog.id)
            }
        ) {
            val painter = rememberImagePainter(
                dog.imgUrl,
                imageLoader = imageLoader,
                builder = {
                    placeholder(R.drawable.dog_placeholder)
                }
            )
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painter,
                contentDescription = "Dog photo",
                contentScale = ContentScale.FillHeight
            )
        }
    }
}
