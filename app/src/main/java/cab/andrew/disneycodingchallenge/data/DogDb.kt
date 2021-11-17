package cab.andrew.disneycodingchallenge.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cab.andrew.disneycodingchallenge.data.domain.Dog
import cab.andrew.disneycodingchallenge.data.domain.DogImage

@Database(entities = [Dog::class, DogImage::class], version = 1, exportSchema = false)
@TypeConverters(value = [StringListTypeConverter::class])
abstract class DogDb: RoomDatabase() {
    abstract fun dogDao(): DogDao
    abstract fun dogImageDao(): DogImageDao
}