package cab.andrew.disneycodingchallenge.ui.dog_detail

import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import cab.andrew.disneycodingchallenge.R
import cab.andrew.disneycodingchallenge.data.domain.DogImage
import cab.andrew.disneycodingchallenge.network.RequestState
import coil.ImageLoader
import coil.compose.rememberImagePainter

@ExperimentalFoundationApi
@Composable
fun DogDetail(
    dogImageState: RequestState<DogImage>,
    imageLoader: ImageLoader
) {

    if (dogImageState is RequestState.Success) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, dogImageState.data.imgUrl)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        val context = LocalContext.current

        Box(contentAlignment = Alignment.Center) {
            val painter = rememberImagePainter(
                dogImageState.data.imgUrl,
                imageLoader = imageLoader,
                builder = {
                    placeholder(R.drawable.dog_placeholder)
                }
            )
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .combinedClickable(
                        onLongClick = { context.startActivity(shareIntent) },
                        onClick = {}
                    ),
                painter = painter,
                contentDescription = "Dog photo"
            )
        }
    }
}
