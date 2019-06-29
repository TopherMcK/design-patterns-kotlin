package com.clm.designpatternskotlin.ducks.behaviors

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.widget.ImageView
import androidx.annotation.RestrictTo

class FlyWithWings(imageView: ImageView) : FlyingBehavior {
    private val duckImageView: ImageView = imageView
    private lateinit var animator: ObjectAnimator

    init {
        setupAnimator()
    }

    @RestrictTo(RestrictTo.Scope.TESTS)
    internal constructor(imageView: ImageView, animator: ObjectAnimator) : this(imageView){
        this.animator = animator
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

    internal fun setupAnimator(){
            animator = ObjectAnimator.ofFloat(duckImageView, "translationY", -90f)
            animator.duration = 1000
    }

    private fun isOkayToStartAnimation(): Boolean {
        return !animator?.isRunning
    }
}