package cab.andrew.disneycodingchallenge.network

import cab.andrew.disneycodingchallenge.utils.ProgressBarState

sealed class RequestState<out T> {
    data class Loading<T>(
        val progressBarState: ProgressBarState = ProgressBarState.Idle,
        val data: T? = null
    ): RequestState<T>()
    data class Success<T>(val data: T): RequestState<T>()
    data class Error<T>(val error: Throwable?): RequestState<T>()
    data class Offline<T>(val data: T): RequestState<T>()
}