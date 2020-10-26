package com.patrykserek.pairprogrammingsession.di

import com.patrykserek.pairprogrammingsession.data.api.ApiService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.servicetitan.com/v1/"

val networkModule = module {

    single<Converter.Factory> { GsonConverterFactory.create() }

    single {
        OkHttpClient.Builder()
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(get())
            .client(get())
            .build()
    }

    single { get<Retrofit>().create(ApiService::class.java) }
}