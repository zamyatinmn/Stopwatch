package com.gb.stopwatch

import android.app.Application
import com.gb.stopwatch.di.KoinDi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                KoinDi.mainModule
            )
        }
    }
}