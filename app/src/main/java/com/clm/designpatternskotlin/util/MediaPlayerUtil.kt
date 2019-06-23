package com.clm.designpatternskotlin.util

import android.content.Context
import android.media.MediaPlayer
import androidx.annotation.RestrictTo

class MediaPlayerUtil constructor(private val appContext: Context) {
    private var mediaPlayer: MediaPlayer

    init {
        mediaPlayer = MediaPlayer()
    }

    @RestrictTo(RestrictTo.Scope.TESTS)
    constructor(appContext: Context, mediaPlayer: MediaPlayer) : this(appContext) {
        this.mediaPlayer = mediaPlayer
    }

    fun playFile(soundFileId: Int) {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
        mediaPlayer.reset()
        loadFile(soundFileId)
        mediaPlayer.start()
    }

    private fun loadFile(soundFileId: Int) {
        mediaPlayer.setDataSource(
            appContext.resources.openRawResourceFd(soundFileId)
        )
        mediaPlayer.prepare()
    }
}