package com.clm.designpatternskotlin.ducks.ui

import androidx.appcompat.app.AppCompatActivity
import com.clm.designpatternskotlin.R
import com.clm.designpatternskotlin.base.BaseActivity

class StrategyActivity: BaseActivity(){
    override fun layoutRes(): Int {
        return R.layout.activity_strategy
    }

    override fun currentActivity(): AppCompatActivity {
        return this
    }

}