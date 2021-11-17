package cab.andrew.disneycodingchallenge.utils

sealed class ProgressBarState {
    object Loading: ProgressBarState()
    object Idle: ProgressBarState()
}
