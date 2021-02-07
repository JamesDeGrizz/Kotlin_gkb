package com.degrizz.james.android_gkb.kotlin_gkb

import androidx.multidex.MultiDexApplication
import org.koin.core.context.startKoin

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(appModule, splashModule, mainModule, noteModule))
        }
    }
}