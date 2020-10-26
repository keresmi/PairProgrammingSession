package com.patrykserek.pairprogrammingsession.app

import android.app.Application
import com.patrykserek.pairprogrammingsession.di.featureModule
import com.patrykserek.pairprogrammingsession.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, featureModule))
        }
    }
}