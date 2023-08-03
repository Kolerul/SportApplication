package com.example.sportapplication.di

import com.example.sportapplication.data.network.FootballApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideGson(): Gson =
        GsonBuilder()
            .setLenient()
            .create()

    @Provides
    fun provideFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)


    @Provides
    fun provideClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
            .build()

    @Provides
    fun provideRetrofit(
        converterFactory: GsonConverterFactory,
        client: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(FootballApi.BASE_URL)
            .client(client)
            .addConverterFactory(converterFactory)
            .build()

    @Provides
    fun provideWeatherApiService(retrofit: Retrofit): FootballApi =
        retrofit.create(FootballApi::class.java)
}