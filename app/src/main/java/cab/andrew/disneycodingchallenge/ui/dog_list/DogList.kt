package cab.andrew.disneycodingchallenge.ui.dog_list

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cab.andrew.disneycodingchallenge.data.domain.Dog
import cab.andrew.disneycodingchallenge.data.domain.DogImage
import cab.andrew.disneycodingchallenge.data.domain.DogResponse
import cab.andrew.disneycodingchallenge.network.RequestState
import cab.andrew.disneycodingchallenge.utils.components.CircularProgress
import coil.ImageLoader


@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun DogList(
    dogs: RequestState<DogResponse<Dog>>,
    dogImages: RequestState<List<DogImage>>,
    dogListViewModel: DogListViewModel,
    navigateToDetailScreen: (dogId: Int) -> Unit,
    imageLoader: ImageLoader
) {

    if (dogs is RequestState.Loading && dogImages is RequestState.Loading) {
        CircularProgress()
    }
    if (dogs is RequestState.Success && dogImages is RequestState.Success) {
        DisplayDogs(
            dogs = dogImages.data,
            navigateToDetailScreen = navigateToDetailScreen,
            imageLoader = imageLoader
        )
    }
    if (dogs is RequestState.Error || dogImages is RequestState.Error || dogs is RequestState.Offline || dogImages is RequestState.Offline) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier
                        .size(100.dp),
                    imageVector = Icons.Filled.Warning,
                    contentDescription = "Warning",
                    tint = Color.Black
                )
                Text(
                    text = "No dogs found!",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.h6.fontSize
                )
                Button(onClick = {
                    dogListViewModel.getDogs()
                },
                    contentPadding = PaddingValues(
                        start = 20.dp,
                        top = 12.dp,
                        end = 20.dp,
                        bottom = 12.dp
                    )
                ) {
                    Text("Retry")
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun DisplayDogs(
    dogs: List<DogImage>,
    navigateToDetailScreen: (dogId: Int) -> Unit,
    imageLoader: ImageLoader
) {
    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            LazyVerticalGrid(cells = GridCells.Fixed(4)) {
                items(dogs) { dog ->
                    DogListItem(
                        dog = dog,
                        navigateToDogScreen = navigateToDetailScreen,
                        imageLoader = imageLoader
                    )
                }
            }
        } else -> {
            LazyVerticalGrid(cells = GridCells.Fixed(2)) {
                items(dogs) { dog ->
                    DogListItem(
                        dog = dog,
                        navigateToDogScreen = navigateToDetailScreen,
                        imageLoader = imageLoader
                    )
                }
            }
        }
    }
}
