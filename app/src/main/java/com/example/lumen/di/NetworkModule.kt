package com.example.lumen.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.example.lumen.BuildConfig
import com.example.lumen.data.remote.SummaryApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideJson(): Json = Json { ignoreUnknownKeys = true }

    @Provides
    @Singleton
    fun provideRetrofit(json: Json): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.SUMMARY_API_BASE_URL)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()

    @Provides
    @Singleton
    fun provideSummaryApi(retrofit: Retrofit): SummaryApi = retrofit.create(SummaryApi::class.java)

}