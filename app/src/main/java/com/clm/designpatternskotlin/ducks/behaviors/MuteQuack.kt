package com.clm.designpatternskotlin.ducks.behaviors

import timber.log.Timber

class MuteQuack : QuackingBehavior {
    override fun quack() {
        Timber.d("I cannot quack")
    }
}