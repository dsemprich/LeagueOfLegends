package com.example.leagueoflegends.di

import com.example.leagueoflegends.network.LolService
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.skydoves.sandwich.coroutines.CoroutinesResponseCallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single {
        OkHttpClient.Builder()
        .addNetworkInterceptor(StethoInterceptor())
        .build()
    }

   single {
        Retrofit.Builder()
            .client(get())
            .baseUrl("http://ddragon.leagueoflegends.com/cdn/10.15.1/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutinesResponseCallAdapterFactory())
            .build()
    }

    single { get<Retrofit>().create(LolService::class.java) }
}