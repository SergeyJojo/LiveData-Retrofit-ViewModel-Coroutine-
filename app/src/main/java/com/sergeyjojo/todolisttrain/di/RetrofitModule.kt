package com.sergeyjojo.todolisttrain.di

import com.sergeyjojo.todolisttrain.NetworkService.RetrofitIServiceInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    val BASE_URL = "https://api.opendota.com/api/"

    @Singleton
    @Provides
    fun provideRetrofitIServiceInterface(retrofit: Retrofit): RetrofitIServiceInterface {
        return retrofit.create(RetrofitIServiceInterface::class.java)
    }


    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(OkHttpClient())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}