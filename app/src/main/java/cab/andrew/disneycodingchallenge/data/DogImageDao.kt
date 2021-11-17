package cab.andrew.disneycodingchallenge.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cab.andrew.disneycodingchallenge.data.domain.Dog
import cab.andrew.disneycodingchallenge.data.domain.DogImage
import kotlinx.coroutines.flow.Flow

@Dao
interface DogImageDao {
    @Query("SELECT * FROM DogImage ORDER BY id ASC")
    fun getAllDogImages(): Flow<List<DogImage>>

    @Query("SELECT * FROM DogImage WHERE id=:dogId")
    fun getSelectedDogImage(dogId: Int): DogImage

    @Query("DELETE FROM DogImage")
    fun deleteAllDogImages()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addDogImage(dogImg: DogImage)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addDogImageList(dogImageList: List<DogImage>)

}