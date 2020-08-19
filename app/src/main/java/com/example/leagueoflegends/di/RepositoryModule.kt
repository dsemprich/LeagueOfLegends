package com.example.leagueoflegends.di

import com.example.leagueoflegends.details.repository.DetailRepository
import com.example.leagueoflegends.main.repository.MainRepository
import org.koin.dsl.module.module

val repositoryModule = module {

    single { MainRepository(get(), get()) }

    single { DetailRepository(get(), get()) }
}