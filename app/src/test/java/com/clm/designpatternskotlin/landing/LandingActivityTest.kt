package com.clm.designpatternskotlin.landing

import com.clm.designpatternskotlin.R
import com.clm.designpatternskotlin.ducks.ui.StrategyActivity
import kotlinx.android.synthetic.main.content_landing.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf

@RunWith(RobolectricTestRunner::class)
class LandingActivityTest {
    private lateinit var landingActivity: LandingActivity

    @Before
    fun setup() {
        landingActivity = Robolectric
            .buildActivity(LandingActivity::class.java)
            .create()
            .resume()
            .get()
    }

    @Test
    fun whenStrategyButtonIsPressedThenStartsStrategyActivity(){
        var expectedLabel = landingActivity.getString(R.string.strategy_label)
        var actualLabel = landingActivity.duckBtn.text.toString()
        assertEquals(expectedLabel, actualLabel)

        landingActivity.duckBtn.performClick()
        assertActivityStarted(StrategyActivity::class.java)
    }

    private fun assertActivityStarted(activityToStart: Class<*>){
        val shadowActivity = shadowOf(landingActivity)
        val startedIntent = shadowActivity.nextStartedActivity
        val shadowIntent = shadowOf(startedIntent)
        assertEquals(activityToStart.name, shadowIntent.intentClass.name)
    }
}