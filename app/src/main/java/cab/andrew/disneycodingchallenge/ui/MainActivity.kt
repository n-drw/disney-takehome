package cab.andrew.disneycodingchallenge.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cab.andrew.disneycodingchallenge.ui.dog_list.DogListViewModel
import cab.andrew.disneycodingchallenge.ui.navigation.NavSetup
import cab.andrew.disneycodingchallenge.ui.theme.DisneyCodingChallengeTheme
import coil.ImageLoader
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
@ExperimentalMaterialApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var imageLoader: ImageLoader
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisneyCodingChallengeTheme {
                val dogListViewModel: DogListViewModel = hiltViewModel()
                navController = rememberNavController()
                NavSetup(navController = navController, dogListViewModel = dogListViewModel, imageLoader = imageLoader)
            }
        }
    }
}