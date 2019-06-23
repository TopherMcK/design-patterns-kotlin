package com.clm.designpatternskotlin.ducks.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.clm.designpatternskotlin.R
import com.clm.designpatternskotlin.base.BaseActivity
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.content_strategy.*

class StrategyActivity: BaseActivity(){

    override fun layoutRes(): Int {
        return R.layout.activity_strategy
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupPagerAdapter()
    }

    override fun currentActivity(): AppCompatActivity {
        return this
    }

    private fun setupPagerAdapter(){
        val viewPager = pager as ViewPager
        val duckPagerAdapter: DuckPagerAdapter = DuckPagerAdapter(this, supportFragmentManager)
        viewPager.adapter = duckPagerAdapter
        val tabLayout = tablayout as TabLayout
        tabLayout.setupWithViewPager(viewPager)
    }
}