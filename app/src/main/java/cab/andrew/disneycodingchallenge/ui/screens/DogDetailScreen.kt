package cab.andrew.disneycodingchallenge.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import cab.andrew.disneycodingchallenge.data.domain.DogImage
import cab.andrew.disneycodingchallenge.network.RequestState
import cab.andrew.disneycodingchallenge.ui.dog_detail.DetailAppBar
import cab.andrew.disneycodingchallenge.ui.dog_detail.DogDetail
import coil.ImageLoader

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun DetailScreen(
    navigateToListScreen: () -> Unit,
    dogImageState: RequestState<DogImage>,
    imageLoader: ImageLoader
) {
    BackHandler(onBack = navigateToListScreen)

    Scaffold(
        topBar = {
            DetailAppBar(navigateToListScreen)
        }
    ) {
        DogDetail( dogImageState = dogImageState, imageLoader = imageLoader)
    }
}