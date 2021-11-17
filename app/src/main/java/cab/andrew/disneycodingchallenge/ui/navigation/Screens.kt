package cab.andrew.disneycodingchallenge.ui.navigation

import androidx.navigation.NavHostController

class Screens(navController: NavHostController) {
    val list: (Int) -> Unit = { dogId ->
        navController.navigate("dogDetail/$dogId")
    }

    val dog: () -> Unit = {
        navController.navigate("list") {
            popUpTo("list"){ inclusive = true }
            restoreState = true
        }
    }
}