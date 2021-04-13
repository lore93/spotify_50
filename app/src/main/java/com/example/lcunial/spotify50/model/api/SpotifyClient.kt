package com.example.lcunial.spotify50.model.api

import com.example.lcunial.spotify50.model.Constants
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class SpotifyClient private constructor(val token : String?){

    fun getSpotifyService() : SpotifyService {
        return initRetrofit().create(SpotifyService::class.java)
    }
    
    private fun initRetrofit() : Retrofit {
        return retrofitBuilder()
    }

    private fun retrofitBuilder(): Retrofit {
        //Converter used for the data serialization
        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder().client(createOkHttpClient())
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson)).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private fun createOkHttpClient() : OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(Interceptor{ chain ->
            val request = chain.request().newBuilder().addHeader("Authorization", "Bearer $token").build()
            return@Interceptor chain.proceed(request)
        }).build()
    }

    companion object {
        @Volatile
        private var INSTANCE: SpotifyClient? = null

        fun createClient(token: String?) {
            synchronized(SpotifyClient::class) {
                INSTANCE = SpotifyClient(token)
            }
        }
        fun getClient(): SpotifyClient? {
            return INSTANCE
        }
    }

}