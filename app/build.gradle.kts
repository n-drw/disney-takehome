plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Android.compileSdk
    buildToolsVersion = Android.buildTools

    defaultConfig {
        applicationId = Android.appId
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = Android.versionCode
        versionName = Android.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeVersion
    }
    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies{
    implementation(Accompanist.swipeRefresh)

    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.lifecycleVmKtx)
    implementation(AndroidX.roomRuntime)
    implementation(AndroidX.roomKtx)
    kapt(AndroidX.roomCompiler)


    implementation(Coil.coil)
    implementation(Compose.activity)
    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.navigation)
    implementation(Compose.hiltNavigation)
    implementation(Compose.tooling)


    implementation(Hilt.android)
    kapt(Hilt.compiler)

    implementation(Material.material)

    implementation(Retrofit.retrofit)
    implementation(Retrofit.retrofit_moshi)
    implementation(Retrofit.moshi_kotlin)
    implementation(Retrofit.moshi_kotlin_codegen)
    implementation(Retrofit.retrofit_moshi_converter)
    implementation(Retrofit.okHttp)
    implementation(Retrofit.okhttp_logging)
    implementation(Retrofit.leak_canary)

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
}
