package cab.andrew.disneycodingchallenge.network

import cab.andrew.disneycodingchallenge.data.domain.Dog
import cab.andrew.disneycodingchallenge.data.domain.DogResponse
import retrofit2.Response
import retrofit2.http.GET


interface DogService {
    @GET("images/")
    suspend fun getDogBreed(): Response<DogResponse<Dog>>
}