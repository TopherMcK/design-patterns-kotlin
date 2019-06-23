package com.clm.designpatternskotlin.ducks.behaviors

import com.clm.designpatternskotlin.util.MediaPlayerUtil

class Quack(mediaPlayerUtil: MediaPlayerUtil, quackSoundResource: Int) : QuackingBehavior {
    private val mediaPlayerUtil: MediaPlayerUtil = mediaPlayerUtil
    private val quackSoundResource: Int = quackSoundResource

    override fun quack() {
        mediaPlayerUtil.playFile(quackSoundResource)
    }
}