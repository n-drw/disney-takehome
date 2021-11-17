### Disney Coding Challenge
-----
An Android dog image gallery app built using Jetpack Compose with Modern Architecture Android Components using a MVVM pattern.

Built with: 2021.1.1 Bumblebee Android Studio

### Built With

- Kotlin
- Jetpack Compose
- Coroutines
- Flow
- StateFlow
- ViewModel
- Accompanist (Compose extension library, pull to refresh)
- Coil (image loading)
- Retrofit and Moshi (networking)

### Package Structure
```
cab.andrew.disneychallenge
├── data # Data handling/local persistence Room (SQLite) database
│   ├── DogDao.kt
│   ├── DogDb.kt
│   ├── DogImageDao.kt
│   ├── TypeConverters.kt
│   └── domain # Model classes
│       ├── Dog.kt
│       ├── DogImage.kt
│       └── DogResponse.kt
├── di #Hilt Dependency Injection Modules
│   ├── CoilModule.kt
│   ├── DatabaseModule.kt
│   └── NetworkModule.kt
├── network #Networking API
│   ├── ConnectionLiveData.kt
│   ├── NetworkHelper.kt
│   ├── NoConnectivityException.kt
│   ├── RequestDebugInterceptor.kt
│   ├── RequestState.kt
│   ├── RetrofitService.kt
│   └── response
│       └── DogBreedResponse.kt
├── repository #Handling data operations
│   └── DogRepository.kt
├── ui #Jetpack Compose and Compose Navigation
│   ├── BaseApplication.kt
│   ├── MainActivity.kt
│   ├── dog_detail
│   │   ├── DogDetail.kt
│   │   └── DogDetailAppBar.kt
│   ├── dog_list
│   │   ├── DogList.kt
│   │   ├── DogListItem.kt
│   │   ├── DogListViewModel.kt
│   │   └── ListAppBar.kt
│   ├── navigation
│   │   ├── Navigation.kt
│   │   ├── Screens.kt
│   │   └── destinations
│   │       ├── DetailComposable.kt
│   │       └── ListComposable.kt
│   ├── screens
│   │   ├── DogDetailScreen.kt
│   │   └── ListScreen.kt
│   └── theme
│       ├── Color.kt
│       ├── Shape.kt
│       ├── Theme.kt
│       └── Type.kt
└── utils #Extension utilities
    ├── Constants.kt
    ├── ProgressBarState.kt
    └── components
        └── CircularProgress.kt

buildSrc #Gradle Dependency Management
├── build.gradle.kts
└── src
    └── main
        └── kotlin
            ├── Accompanist.kt
            ├── Android.kt
            ├── AndroidX.kt
            ├── Build.kt
            ├── Coil.kt
            ├── Compose.kt
            ├── Hilt.kt
            ├── Material.kt
            └── Retrofit.kt
```
