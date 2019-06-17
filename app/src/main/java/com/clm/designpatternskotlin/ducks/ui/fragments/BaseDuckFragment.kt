package com.clm.designpatternskotlin.ducks.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.clm.designpatternskotlin.ducks.behaviors.FlyingBehavior
import com.clm.designpatternskotlin.ducks.behaviors.QuackingBehavior
import com.clm.designpatternskotlin.util.MediaPlayerUtil
import org.koin.android.ext.android.inject

abstract class BaseDuckFragment: Fragment(){
    protected val mediaPlayerUtil: MediaPlayerUtil by inject()

    @LayoutRes
    protected abstract fun layoutRes():Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view: View = inflater.inflate(layoutRes(), container, false)
        return view
    }

    protected abstract fun imageResource():Int
    protected abstract fun flyingBehavior():FlyingBehavior
    protected abstract fun quackingBehavior():QuackingBehavior
}