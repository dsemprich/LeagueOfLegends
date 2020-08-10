package com.example.leagueoflegends.di

import android.app.Application
import androidx.room.Room
import com.example.leagueoflegends.details.db.ChampionInfoDao
import com.example.leagueoflegends.main.db.ChampionsDao
import com.example.leagueoflegends.persistence.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, "lol.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideChampionDao(appDatabase: AppDatabase): ChampionsDao {
        return appDatabase.championsDao()
    }

    @Provides
    @Singleton
    fun provideChampionInfoDao(appDatabase: AppDatabase): ChampionInfoDao {
        return appDatabase.championsInfoDao()
    }
}