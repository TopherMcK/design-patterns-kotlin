package com.clm.designpatternskotlin.ducks.behaviors

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.widget.ImageView

class FlyWithWings(imageView: ImageView) : FlyingBehavior {
    private val duckImageView: ImageView = imageView
    private lateinit var animator: ObjectAnimator

    init {
        setupAnimator()
    }

    override fun fly() {
        if(isOkayToStartAnimation()){
            animator.addListener(object: AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    animation.removeListener(this)
                    (animation as ObjectAnimator).reverse()
                    animation.start()
                }
            })
            animator.start()
        }
    }

    private fun setupAnimator(){
            animator = ObjectAnimator.ofFloat(duckImageView, "translationY", -90f)
            animator.setDuration(1000)
    }

    private fun isOkayToStartAnimation(): Boolean {
        return !animator?.isRunning
    }
}