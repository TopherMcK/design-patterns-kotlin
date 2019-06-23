package com.clm.designpatternskotlin.ducks.ui.fragments

import com.clm.designpatternskotlin.R
import com.clm.designpatternskotlin.ducks.behaviors.FlyWithWings
import com.clm.designpatternskotlin.ducks.behaviors.Quack
import kotlinx.android.synthetic.main.duck_image_wrapper.*

class Readhead : BaseDuck() {
    override fun imageResource(): Int {
        return R.drawable.redhead_duck
    }

    override fun setupBehaviors() {
        flyingBehavior = FlyWithWings(duck_image_view)
        quackingBehavior = Quack(mediaPlayerUtil, R.raw.redhead_duck)
    }
}