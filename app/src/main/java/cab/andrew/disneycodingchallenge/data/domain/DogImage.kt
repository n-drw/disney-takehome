package cab.andrew.disneycodingchallenge.data.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class DogImage(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val imgUrl: String
)