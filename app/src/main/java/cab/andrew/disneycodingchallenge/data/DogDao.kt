package cab.andrew.disneycodingchallenge.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cab.andrew.disneycodingchallenge.data.domain.Dog
import kotlinx.coroutines.flow.Flow


@Dao
interface DogDao {
    @Query("SELECT * FROM Dog ORDER BY id ASC")
    fun getAllDogs(): List<Dog>

    @Query("SELECT * FROM Dog WHERE id=:dogId")
    fun getSelectedDog(dogId: String): Dog

    @Query("DELETE FROM Dog")
    fun deleteAllDogs()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addDog(dog: Dog)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addDogList(dogList: List<Dog>?)

}