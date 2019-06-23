package com.clm.designpatternskotlin.ducks.behaviors

import com.clm.designpatternskotlin.R
import com.clm.designpatternskotlin.util.MediaPlayerUtil

class Squeak(mediaPlayerUtil: MediaPlayerUtil) : QuackingBehavior {
    val mediaPlayerUtil: MediaPlayerUtil = mediaPlayerUtil

    override fun quack() {
        mediaPlayerUtil.playFile(R.raw.squeak)
    }

}