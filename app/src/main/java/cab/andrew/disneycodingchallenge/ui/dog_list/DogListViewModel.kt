package cab.andrew.disneycodingchallenge.ui.dog_list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cab.andrew.disneycodingchallenge.data.domain.Dog
import cab.andrew.disneycodingchallenge.data.domain.DogImage
import cab.andrew.disneycodingchallenge.data.domain.DogResponse
import cab.andrew.disneycodingchallenge.network.RequestState
import cab.andrew.disneycodingchallenge.repository.DogRepository
import cab.andrew.disneycodingchallenge.utils.Constants.DOG_SUB_BREED
import cab.andrew.disneycodingchallenge.utils.ProgressBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogListViewModel @Inject constructor(
    private val repository: DogRepository
): ViewModel() {
    private val _allDogsState =
        MutableStateFlow<RequestState<DogResponse<Dog>>>(RequestState.Loading(ProgressBarState.Idle))
    val allDogsState: StateFlow<RequestState<DogResponse<Dog>>> = _allDogsState

    private val _allDogImagesState =
        MutableStateFlow<RequestState<List<DogImage>>>(RequestState.Loading(ProgressBarState.Idle))
    val allDogImagesState: StateFlow<RequestState<List<DogImage>>> = _allDogImagesState


    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing.asStateFlow()

    init {
        getDogs()
        getDogImages()
    }

    fun getDogs() {
        viewModelScope.launch {
            repository.execute().collect { state ->
                when (state) {
                    is RequestState.Loading -> {
                        _allDogsState.value = RequestState.Loading(state.progressBarState)
                        _isRefreshing.emit(true)
                    }
                    is RequestState.Success -> {
                        _allDogsState.value = RequestState.Success(state.data!!)
                        _isRefreshing.emit(false)
                    }
                    is RequestState.Error -> {
                        _isRefreshing.emit(false)
                        _allDogsState.value = RequestState.Error(state.error)
                        Log.d(
                            "Error",
                            "getDogs: ${state.error}"
                        )
                    }
                    is RequestState.Offline -> {
                        _isRefreshing.emit(false)
                        _allDogsState.value = RequestState.Offline(state.data!!)
                    }
                }
            }
        }
    }

    private fun getDogImages() {
        _allDogImagesState.value = RequestState.Loading(ProgressBarState.Loading)
        try {
            viewModelScope.launch {
                repository.getAllDogImages.collect {
                    _allDogImagesState.value = RequestState.Success(it)
                }
            }
        } catch (e: Exception) {
            _allDogImagesState.value = RequestState.Error(e)
        }
    }

    private val _selectedDog =
        MutableStateFlow<RequestState<DogImage>>(RequestState.Loading(ProgressBarState.Idle))
    val selectedDog: StateFlow<RequestState<DogImage>> = _selectedDog

    val subBreed: MutableState<String> = mutableStateOf(DOG_SUB_BREED)

    fun getSelectedDog(dogId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getSelectedDog(dogId).collect { state ->
                when(state) {
                    is RequestState.Loading -> {
                        _selectedDog.value = RequestState.Loading(state.progressBarState)
                    }
                    is RequestState.Success -> {
                        _selectedDog.value = RequestState.Success(state.data)
                    }
                    is RequestState.Error -> {
                        _selectedDog.value = RequestState.Error(state.error)
                        Log.d(
                            "Error",
                            "getDogs: ${state.error}"
                        )
                    }
                    is RequestState.Offline -> {
                        _selectedDog.value = RequestState.Offline(state.data)
                    }

                }

            }
        }
    }
}