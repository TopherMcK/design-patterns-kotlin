package com.clm.designpatternskotlin.ducks.ui.fragments

import com.clm.designpatternskotlin.R
import com.clm.designpatternskotlin.ducks.behaviors.FlyNoWay
import com.clm.designpatternskotlin.ducks.behaviors.Squeak

class RubberDuck : BaseDuck() {
    override fun imageResource(): Int {
        return R.drawable.rubber_duck_pic
    }

    override fun setupBehaviors() {
        flyingBehavior = FlyNoWay()
        quackingBehavior = Squeak(mediaPlayerUtil)
    }
}