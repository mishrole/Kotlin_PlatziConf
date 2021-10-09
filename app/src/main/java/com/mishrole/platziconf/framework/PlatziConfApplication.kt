package com.mishrole.platziconf.framework

import android.app.Application
import com.mishrole.platziconf.framework.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class PlatziConfApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PlatziConfApplication)
            modules(getModule())
        }
    }

    private fun getModule() : List<Module> {
        return listOf(
            viewModelModule
        )
    }
}