object AndroidX {
    private const val coreKtxVersion = "1.6.0"
    
    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"

    private const val appCompatVersion = "1.3.0"
    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"

    private const val lifecycleVmKtxVersion = "2.4.0-alpha02"
    const val lifecycleVmKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVmKtxVersion"

    private const val roomVersion = "2.3.0"
    const val roomRuntime = "androidx.room:room-runtime:${AndroidX.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${AndroidX.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${AndroidX.roomVersion}"
}
