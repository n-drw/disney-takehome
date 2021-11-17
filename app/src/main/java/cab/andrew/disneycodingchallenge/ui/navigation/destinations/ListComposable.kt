package cab.andrew.disneycodingchallenge.ui.navigation.destinations

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import cab.andrew.disneycodingchallenge.ui.dog_list.DogListViewModel
import cab.andrew.disneycodingchallenge.ui.screens.ListScreen
import coil.ImageLoader

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
fun NavGraphBuilder.listComposable(
    navigateToDogScreen: (dogId: Int) -> Unit,
    dogListViewModel: DogListViewModel,
    imageLoader: ImageLoader
){
    composable(
        route = "list",
    ){
        ListScreen(
            navigateToDogScreen = navigateToDogScreen,
            dogListViewModel = dogListViewModel,
            imageLoader = imageLoader
        )
    }
}