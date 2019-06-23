package com.clm.designpatternskotlin

import android.app.Application
import com.clm.designpatternskotlin.di.utilModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber
import java.util.Collections.singletonList

class DesignPatternsKotlinApplication : Application() {

    override fun onCreate(){
        super.onCreate()

        val context = this

        startKoin {
            modules(
                singletonList(utilModule)
            ).androidContext(context)
        }

        Timber.plant(Timber.DebugTree())
    }
}