package cab.andrew.disneycodingchallenge.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import cab.andrew.disneycodingchallenge.ui.dog_list.DogListViewModel
import cab.andrew.disneycodingchallenge.ui.navigation.destinations.detailComposable
import cab.andrew.disneycodingchallenge.ui.navigation.destinations.listComposable
import coil.ImageLoader

@ExperimentalAnimationApi
@Composable
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalFoundationApi

fun NavSetup (
    navController: NavHostController,
    dogListViewModel: DogListViewModel,
    imageLoader: ImageLoader
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(navController, startDestination = "list") {
        listComposable(
            navigateToDogScreen = screen.list,
            dogListViewModel = dogListViewModel,
            imageLoader = imageLoader
        )
        detailComposable(
            navigateToListScreen = screen.dog,
            dogListViewModel = dogListViewModel,
            imageLoader = imageLoader
        )
    }

}