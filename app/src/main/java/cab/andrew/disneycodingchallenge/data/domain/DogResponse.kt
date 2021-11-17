package cab.andrew.disneycodingchallenge.data.domain

import androidx.room.Entity
import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverters
import cab.andrew.disneycodingchallenge.data.StringListTypeConverter
import cab.andrew.disneycodingchallenge.utils.Constants
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DogResponse<T>(
    @field:Json(name = "message")
    val message: List<String>
) {
    fun toList(): List<String> = message.toList()
}