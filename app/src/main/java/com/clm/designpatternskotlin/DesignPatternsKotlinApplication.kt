package com.clm.designpatternskotlin

import android.app.Application
import com.clm.designpatternskotlin.di.designPatternsKotlinModule
import com.clm.designpatternskotlin.di.utilModule
import com.clm.designpatternskotlin.lifecycle.DesignPatternsKotlinLifecycleListener
import org.koin.core.context.startKoin

class DesignPatternsKotlinApplication : Application() {

    override fun onCreate(){
        super.onCreate()

        startKoin {
            modules(
                utilModule
            )
        }

//        registerActivityLifecycleCallbacks(DesignPatternsKotlinLifecycleListener())
    }
}