package com.clm.designpatternskotlin.di

import com.clm.designpatternskotlin.util.MediaPlayerUtil
import org.koin.dsl.module
import org.mockito.Mockito.mock

val testUtilModule = module {
    single { mock(MediaPlayerUtil::class.java) }
}