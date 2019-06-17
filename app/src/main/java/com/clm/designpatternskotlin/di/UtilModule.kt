package com.clm.designpatternskotlin.di

import com.clm.designpatternskotlin.util.MediaPlayerUtil
import org.koin.dsl.module

val utilModule = module {
    single {MediaPlayerUtil(get())}
}