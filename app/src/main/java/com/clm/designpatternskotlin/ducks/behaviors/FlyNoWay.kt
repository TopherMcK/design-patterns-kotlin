package com.clm.designpatternskotlin.ducks.behaviors

import timber.log.Timber

class FlyNoWay : FlyingBehavior{
    override fun fly() {
        Timber.d("No way!");
    }
}