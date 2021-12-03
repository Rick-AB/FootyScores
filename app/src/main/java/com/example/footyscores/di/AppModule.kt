package com.example.footyscores.di

import com.example.footyscores.BuildConfig
import com.example.footyscores.common.Constants.BASE_URL
import com.example.footyscores.common.Constants.RAPID_API_HOST
import com.example.footyscores.data.remote.ApiFootball
import com.example.footyscores.data.repository.FootyScoresRepoImpl
import com.example.footyscores.domain.repository.FootyScoresRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
        val request: Request =
            chain.request().newBuilder()
                .addHeader("x-rapidapi-key", BuildConfig.API_FOOTBALL_KEY)
                .addHeader("x-rapidapi-host", RAPID_API_HOST)
                .build()
        chain.proceed(request)
    }.build()

    @Provides
    @Singleton
    fun provideApiFootball(httpClient: OkHttpClient): ApiFootball = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()
        .create(ApiFootball::class.java)

    @Provides
    @Singleton
    fun provideRepo(apiFootball: ApiFootball): FootyScoresRepo =
        FootyScoresRepoImpl(apiFootball)

}