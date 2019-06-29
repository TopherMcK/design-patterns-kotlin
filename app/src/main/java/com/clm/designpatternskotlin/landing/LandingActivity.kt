package com.clm.designpatternskotlin.landing

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.clm.designpatternskotlin.R
import com.clm.designpatternskotlin.base.BaseActivity
import com.clm.designpatternskotlin.ducks.ui.StrategyActivity
import kotlinx.android.synthetic.main.content_landing.*
import timber.log.Timber

class LandingActivity : BaseActivity(){

    override fun layoutRes(): Int {
        return R.layout.activity_landing
    }

    override fun currentActivity(): AppCompatActivity {
        return this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBtns()
    }

    private fun onViewClicked(view: View) {
        when (view.id) {
            R.id.duckBtn -> launchPatternActivity(StrategyActivity::class.java)
//            R.id.weatherBtn -> launchPatternActivity(WeatherStationActivity::class.java)
//            R.id.remoteBtn -> launchPatternActivity(CommandActivity::class.java)
            else -> Timber.w("Unknown button clicked.")
        }
    }

    private fun setupBtns(){
        duckBtn.setOnClickListener {
            onViewClicked(it)
        }
        weatherBtn.setOnClickListener {
            onViewClicked(it)
        }
        remoteBtn.setOnClickListener {
            onViewClicked(it)
        }
    }
}