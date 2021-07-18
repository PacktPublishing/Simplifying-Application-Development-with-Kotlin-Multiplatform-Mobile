package com.nagyrobi144.dogify.android

import android.app.Application
import com.nagyrobi144.dogify.di.initKoin
import org.koin.android.ext.koin.androidContext

class DogifyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@DogifyApplication)
        }
    }
}