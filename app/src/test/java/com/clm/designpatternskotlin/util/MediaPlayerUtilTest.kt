package com.clm.designpatternskotlin.util

import android.content.Context
import android.content.res.AssetFileDescriptor
import android.content.res.Resources
import android.media.MediaPlayer
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MediaPlayerUtilTest {
    @Mock private lateinit var context: Context
    @Mock private lateinit var mediaPlayer: MediaPlayer
    @Mock private lateinit var resources: Resources

    private lateinit var mediaPlayerUtil: MediaPlayerUtil

    @Before
    fun setup(){
        Mockito.`when`(context.resources).thenReturn(resources)
        mediaPlayerUtil = MediaPlayerUtil(context, mediaPlayer)
    }

    @Test
    fun whenMediaPlayerIsPlayingThenCallsStopAndThenPlaysFile(){
        Mockito.`when`(mediaPlayer.isPlaying).thenReturn(true)
        mediaPlayerUtil.playFile(1)
        verify(mediaPlayer).stop()
        verify(mediaPlayer).reset()
        verify(mediaPlayer).setDataSource(ArgumentMatchers.nullable(AssetFileDescriptor::class.java))
        verify(mediaPlayer).prepare()
        verify(mediaPlayer).start()
    }

    @Test
    fun whenMediaPlayerIsNotPlayingThenNeverCallsStopAndThenPlaysFile(){
        mediaPlayerUtil.playFile(1)
        verify(mediaPlayer, never()).stop()
        verify(mediaPlayer).reset()
        verify(mediaPlayer).setDataSource(ArgumentMatchers.nullable(AssetFileDescriptor::class.java))
        verify(mediaPlayer).prepare()
        verify(mediaPlayer).start()
    }
}