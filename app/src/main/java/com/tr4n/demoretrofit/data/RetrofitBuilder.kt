package com.tr4n.demoretrofit.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiSingleton {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    private var placeholderApi: PlaceholderApi? = null

    /**
     * Get only one instance of API.
     * if API is not created, build new one
     */
    fun getInstance(): PlaceholderApi {
        // if api != null -> return api
        // else api =  buildRetrofit(baseUrl);  return api

        return placeholderApi ?: buildRetrofit(BASE_URL).also {
            placeholderApi = it
        }
    }

    private fun buildRetrofit(baseUrl: String): PlaceholderApi {
        val interceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val builder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return builder.create(PlaceholderApi::class.java)
    }
}
