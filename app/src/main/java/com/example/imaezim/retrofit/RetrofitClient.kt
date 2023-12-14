package com.example.projecttest.retrofit

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofitClient: Retrofit? = null

    fun getClient(): Retrofit? {
        Log.d("로그", "RetrofitClient - getClient() called")

        val clientBuilder = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        clientBuilder.addInterceptor(loggingInterceptor)

        if(retrofitClient == null){
            retrofitClient = Retrofit.Builder()
                .baseUrl("http://34.64.197.160:8000")
                .addConverterFactory(GsonConverterFactory.create())
                .client(clientBuilder.build())
                .build()
        }
        return retrofitClient
    }
}