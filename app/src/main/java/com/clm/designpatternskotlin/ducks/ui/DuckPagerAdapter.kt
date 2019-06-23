package com.clm.designpatternskotlin.ducks.ui

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.clm.designpatternskotlin.R
import com.clm.designpatternskotlin.ducks.ui.fragments.*

class DuckPagerAdapter(context: Context, fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    val context: Context = context

    override fun getItem(position: Int): Fragment {
        var duck: BaseDuck?

        when(position){
            0 -> duck = Mallard()

            1 -> duck = Readhead()

            2 -> duck = RubberDuck()

            3 -> duck = WoodenDuck()

            else -> duck = null
        }

        return duck as Fragment
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        super.getPageTitle(position)

        when(position){
            0 -> return context.getString(R.string.mallard_duck_label)

            1 -> return context.getString(R.string.redhead_duck_label)

            2 -> return context.getString(R.string.rubber_duck_label)

            3 -> return context.getString(R.string.wooden_duck_label)

            else -> return null
        }
    }
}