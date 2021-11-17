package cab.andrew.disneycodingchallenge.ui.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import cab.andrew.disneycodingchallenge.ui.dog_list.DogListViewModel
import cab.andrew.disneycodingchallenge.ui.screens.DetailScreen
import coil.ImageLoader

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalAnimationApi
fun NavGraphBuilder.detailComposable(
    dogListViewModel: DogListViewModel,
    imageLoader: ImageLoader,
    navigateToListScreen: () -> Unit
) {
    composable(
        route = "dogDetail/{dogId}",
        arguments = listOf(navArgument("dogId"){
            type = NavType.IntType
        }),
    ) { navBackStackEntry ->
        val dogId = navBackStackEntry.arguments!!.getInt("dogId")
        LaunchedEffect(key1 = dogId){
            dogListViewModel.getSelectedDog(dogId)
        }
        val selectedDog by dogListViewModel.selectedDog.collectAsState()

        DetailScreen(
            navigateToListScreen = navigateToListScreen,
            dogImageState = selectedDog,
            imageLoader = imageLoader
        )
    }
}