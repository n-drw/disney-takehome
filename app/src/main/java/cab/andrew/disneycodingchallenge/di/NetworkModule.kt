package cab.andrew.disneycodingchallenge.di

import android.content.Context
import android.net.ConnectivityManager
import cab.andrew.disneycodingchallenge.network.ConnectionLiveData
import cab.andrew.disneycodingchallenge.network.DogService
import cab.andrew.disneycodingchallenge.network.NetworkHelper
import cab.andrew.disneycodingchallenge.network.RequestDebugInterceptor
import cab.andrew.disneycodingchallenge.utils.Constants.DOG_BREED
import cab.andrew.disneycodingchallenge.utils.Constants.DOG_SUB_BREED
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideConnectivityManager(@ApplicationContext context: Context) =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    @Provides
    @Singleton
    fun provideNetworkHelper(connectivityManager: ConnectivityManager) =
        NetworkHelper(connectivityManager)

    @Provides
    @Singleton
    fun provideConnectionLiveData(connectivityManager: ConnectivityManager) =
        ConnectionLiveData(connectivityManager)

    @Provides
    @Singleton
    fun provideRequestDebugInterceptor(): RequestDebugInterceptor {
        return RequestDebugInterceptor()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: RequestDebugInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://dog.ceo/api/breed/${DOG_BREED.lowercase(Locale.getDefault())}/${DOG_SUB_BREED.lowercase(
                Locale.getDefault()
            )}/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideDogService(retrofit: Retrofit): DogService {
        return retrofit.create(DogService::class.java)
    }
}