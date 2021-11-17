package cab.andrew.disneycodingchallenge.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import cab.andrew.disneycodingchallenge.ui.dog_list.DogList
import cab.andrew.disneycodingchallenge.ui.dog_list.DogListViewModel
import cab.andrew.disneycodingchallenge.ui.dog_list.ListAppBar
import cab.andrew.disneycodingchallenge.utils.Constants.DOG_BREED
import cab.andrew.disneycodingchallenge.utils.Constants.DOG_SUB_BREED
import coil.ImageLoader
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun ListScreen(
    navigateToDogScreen: (dogId: Int) -> Unit,
    dogListViewModel: DogListViewModel,
    imageLoader: ImageLoader
) {
    val dogs by dogListViewModel.allDogsState.collectAsState()
    val dogImages by dogListViewModel.allDogImagesState.collectAsState()

    Scaffold (
        topBar = {
            ListAppBar(dogBreed = DOG_BREED, dogSubBreed = DOG_SUB_BREED)
        }
    ) {

        val isRefreshing by dogListViewModel.isRefreshing.collectAsState()

        SwipeRefresh(state = rememberSwipeRefreshState(isRefreshing), onRefresh = { dogListViewModel.getDogs() }) {
            DogList(
                dogListViewModel = dogListViewModel,
                dogs = dogs,
                dogImages = dogImages,
                navigateToDetailScreen = navigateToDogScreen,
                imageLoader = imageLoader
            )
        }
    }
}