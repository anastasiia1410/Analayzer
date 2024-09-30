package com.example.analayzer.core

import android.app.Application
import com.example.analayzer.di.initKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}