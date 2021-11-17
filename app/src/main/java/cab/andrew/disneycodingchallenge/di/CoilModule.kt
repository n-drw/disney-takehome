package cab.andrew.disneycodingchallenge.di

import android.app.Application
import cab.andrew.disneycodingchallenge.R
import coil.ImageLoader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CoilModule {
    @Provides
    @Singleton
    fun provideImageLoader(app: Application): ImageLoader {
        return ImageLoader.Builder(app)
            .placeholder(R.drawable.dog_placeholder)
            .availableMemoryPercentage(0.25)
            .crossfade(true)
            .build()
    }
}