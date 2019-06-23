package com.clm.designpatternskotlin

import android.app.Application
import com.clm.designpatternskotlin.di.utilModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import timber.log.Timber

class DesignPatternsKotlinApplication : Application() {

    override fun onCreate(){
        super.onCreate()

        if(GlobalContext.getOrNull() == null) {
            val context = this
            startKoin {
                modules(
                    listOf(utilModule)
                ).androidContext(context)
            }

            Timber.plant(Timber.DebugTree())
        }
    }
}