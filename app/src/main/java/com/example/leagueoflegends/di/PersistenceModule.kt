package com.example.leagueoflegends.di

import androidx.room.Room
import com.example.leagueoflegends.persistence.AppDatabase
import org.koin.dsl.module.module

val persistenceModule = module {

    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "lol.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().championsDao() }

    single { get<AppDatabase>().championsInfoDao() }
}