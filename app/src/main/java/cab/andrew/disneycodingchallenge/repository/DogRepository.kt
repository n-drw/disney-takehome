package cab.andrew.disneycodingchallenge.repository

import android.util.Log
import cab.andrew.disneycodingchallenge.data.DogImageDao
import cab.andrew.disneycodingchallenge.data.domain.Dog
import cab.andrew.disneycodingchallenge.data.domain.DogImage
import cab.andrew.disneycodingchallenge.data.domain.DogResponse
import cab.andrew.disneycodingchallenge.network.DogService
import cab.andrew.disneycodingchallenge.network.NoConnectivityException
import cab.andrew.disneycodingchallenge.network.RequestState
import cab.andrew.disneycodingchallenge.utils.ProgressBarState
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ViewModelScoped
class DogRepository @Inject constructor(
    private val service: DogService,
    private val dogImageDao: DogImageDao
) {
    fun execute(): Flow<RequestState<DogResponse<Dog>?>> = flow {
        try {
            emit(RequestState.Loading(progressBarState = ProgressBarState.Loading))
            val response = service.getDogBreed()
            if (response.isSuccessful) {
                val dogImgState: DogResponse<Dog> =
                    response.body() ?: throw Exception(response.code().toString())

                val dogImgUrls: List<String> =
                    response.body()?.toList() ?: throw Exception(response.code().toString())

                val dogImageList: List<DogImage> = dogImgUrls.map { dogImg ->
                    DogImage(
                        imgUrl = dogImg
                    )
                }

                dogImageDao.addDogImageList(dogImageList)
                emit(RequestState.Success(dogImgState))
            }
        } catch (exception: Exception) {
            if (exception is NoConnectivityException) {
                emit(RequestState.Offline(null))
            } else {
                emit(RequestState.Error(exception.cause))
            }
        }
    }.flowOn(Dispatchers.IO)

    fun getSelectedDog(dogId: Int): Flow<RequestState<DogImage>> = flow {
        emit(RequestState.Loading(progressBarState = ProgressBarState.Loading))
        Log.d("dog id = ", "getSelectedDog: $dogId")
        val cachedDog: DogImage = dogImageDao.getSelectedDogImage(dogId)
        emit(RequestState.Success(cachedDog))
    }.flowOn(Dispatchers.IO)

    val getAllDogImages: Flow<List<DogImage>> = dogImageDao.getAllDogImages()
}