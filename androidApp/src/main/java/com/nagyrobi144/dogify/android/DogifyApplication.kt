package com.nagyrobi144.dogify.android

import android.app.Application
import com.nagyrobi144.dogify.di.initKoin

class DogifyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}