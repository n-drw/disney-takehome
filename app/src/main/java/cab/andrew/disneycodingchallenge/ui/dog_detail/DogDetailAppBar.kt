package cab.andrew.disneycodingchallenge.ui.dog_detail

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import cab.andrew.disneycodingchallenge.R
import cab.andrew.disneycodingchallenge.ui.theme.topAppBarBackgroundColor
import cab.andrew.disneycodingchallenge.ui.theme.topAppBarContentColor
import cab.andrew.disneycodingchallenge.utils.Constants

@Composable
fun DetailAppBar(navigateToListScreen: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = navigateToListScreen)
            {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.back_button),
                    tint = MaterialTheme.colors.topAppBarContentColor
                )
            }
        },
        title = {
            Text(
                text = "${Constants.DOG_BREED}, ${Constants.DOG_SUB_BREED}",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}