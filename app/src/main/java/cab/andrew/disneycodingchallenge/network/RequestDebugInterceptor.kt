package cab.andrew.disneycodingchallenge.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class RequestDebugInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        Log.d("Interceptor","Request : $request")
        val response = chain.proceed(request)
        Log.d("Interceptor","Response : $response")
        return response
    }
}