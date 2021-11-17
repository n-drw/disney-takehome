package cab.andrew.disneycodingchallenge.di

import android.content.Context
import androidx.room.Room
import cab.andrew.disneycodingchallenge.data.DogDb
import cab.andrew.disneycodingchallenge.data.StringListTypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context,
        stringListTypeConverter: StringListTypeConverter
    ) = Room.databaseBuilder(
        context,
        DogDb::class.java,
        "DisneyDogs.db"
    )
        .fallbackToDestructiveMigration()
        .addTypeConverter(stringListTypeConverter)
        .build()

    @Singleton
    @Provides
    fun provideDogDao(database: DogDb) = database.dogDao()

    @Singleton
    @Provides
    fun provideDogImageDao(database: DogDb) = database.dogImageDao()

    @Provides
    @Singleton
    fun provideStringListTypeConverter(moshi: Moshi): StringListTypeConverter = StringListTypeConverter(moshi)
}