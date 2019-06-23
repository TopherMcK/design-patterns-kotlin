package com.clm.designpatternskotlin.ducks.ui.fragments

import android.os.Bundle
import androidx.annotation.DrawableRes
import com.clm.designpatternskotlin.R
import com.clm.designpatternskotlin.base.BaseFragment
import com.clm.designpatternskotlin.ducks.behaviors.FlyingBehavior
import com.clm.designpatternskotlin.ducks.behaviors.QuackingBehavior
import com.clm.designpatternskotlin.util.MediaPlayerUtil
import kotlinx.android.synthetic.main.duck_buttons.*
import kotlinx.android.synthetic.main.duck_image_wrapper.*
import org.koin.android.ext.android.inject

abstract class BaseDuck : BaseFragment() {
    protected lateinit var flyingBehavior: FlyingBehavior
    protected lateinit var quackingBehavior: QuackingBehavior

    protected val mediaPlayerUtil: MediaPlayerUtil by inject()

    @DrawableRes
    protected abstract fun imageResource(): Int

    protected abstract fun setupBehaviors()

    override fun layoutRes(): Int {
        return R.layout.fragment_content_duck
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        display()
        setupBehaviors()
        fly_btn.setOnClickListener { performFly() }
        quack_btn.setOnClickListener { performQuack() }
        swim_btn.setOnClickListener { swim() }
    }

    private fun display() {
        duck_image_view.setImageDrawable(activity?.getDrawable(imageResource()))
    }

    private fun performFly() {
        flyingBehavior.fly()
    }

    private fun performQuack() {
        quackingBehavior.quack()
    }

    private fun swim() {
        mediaPlayerUtil.playFile(R.raw.swim_splash)
    }
}