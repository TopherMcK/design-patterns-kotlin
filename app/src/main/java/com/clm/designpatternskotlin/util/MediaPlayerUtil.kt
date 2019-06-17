package com.clm.designpatternskotlin.util

import android.content.Context
import android.media.MediaPlayer

class MediaPlayerUtil(val appContext: Context){
    val mediaPlayer: MediaPlayer = MediaPlayer()

    fun playFile(soundFileId: Int){
        loadFile(soundFileId)
        mediaPlayer.setOnCompletionListener {
            mediaPlayer.reset()
        }
        mediaPlayer.start()
    }

    private fun loadFile(soundFileId: Int){
        mediaPlayer.setDataSource(
            appContext.getResources().openRawResourceFd(soundFileId)
        )
        mediaPlayer.prepare()
    }
}