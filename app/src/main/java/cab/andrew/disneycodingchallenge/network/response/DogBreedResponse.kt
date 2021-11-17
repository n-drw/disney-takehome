package cab.andrew.disneycodingchallenge.network.response

import com.squareup.moshi.Json

data class DogBreedResponse (
    @Json(name = "message")
    val imageUrls: List<String>
)