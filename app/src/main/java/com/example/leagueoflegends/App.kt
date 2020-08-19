package com.example.leagueoflegends

import android.app.Application
import com.example.leagueoflegends.di.*
import com.facebook.stetho.Stetho
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // Koin Android logger
        startKoin(this, listOf(
            viewModelModule,
            networkModule,
            persistenceModule,
            repositoryModule)
        )
        Stetho.initializeWithDefaults(this)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}