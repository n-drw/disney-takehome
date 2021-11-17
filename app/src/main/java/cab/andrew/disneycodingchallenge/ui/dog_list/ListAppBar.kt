package cab.andrew.disneycodingchallenge.ui.dog_list

import android.os.Process
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import cab.andrew.disneycodingchallenge.R
import cab.andrew.disneycodingchallenge.ui.theme.topAppBarBackgroundColor
import cab.andrew.disneycodingchallenge.ui.theme.topAppBarContentColor

@Composable
fun ListAppBar(dogBreed: String, dogSubBreed: String?) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {
                Process.killProcess(Process.myPid())
            })
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
                text = "$dogBreed, $dogSubBreed",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
    )
}