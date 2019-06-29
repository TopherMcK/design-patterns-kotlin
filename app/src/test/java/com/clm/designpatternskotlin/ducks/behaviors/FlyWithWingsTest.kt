package com.clm.designpatternskotlin.ducks.behaviors

import android.animation.ObjectAnimator
import android.widget.ImageView
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FlyWithWingsTest {
    @Mock
    private lateinit var imageView: ImageView
    @Mock private lateinit var animator: ObjectAnimator

    private lateinit var flyWithWings: FlyWithWings

    @Before
    fun setup(){

        flyWithWings = FlyWithWings(imageView, animator)
    }
}