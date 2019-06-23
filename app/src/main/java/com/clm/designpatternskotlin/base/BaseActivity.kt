package com.clm.designpatternskotlin.base

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.clm.designpatternskotlin.R
import com.clm.designpatternskotlin.ducks.ui.StrategyActivity
import com.clm.designpatternskotlin.landing.LandingActivity
import com.google.android.material.navigation.NavigationView

abstract class BaseActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    @LayoutRes
    protected abstract fun layoutRes():Int

    protected abstract fun currentActivity(): AppCompatActivity

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())

        val toolBar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolBar)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navView = findViewById<NavigationView>(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()

        if (id == R.id.nav_home && currentActivity() !is LandingActivity) {
            launchPatternActivity(LandingActivity::class.java)
        } else if (id == R.id.nav_strategy && currentActivity() !is StrategyActivity) {
            launchPatternActivity(StrategyActivity::class.java)
//        } else if (id == R.id.nav_command && lifecycleListener.getCurrentActivity() !is CommandActivity) {
//            launchPatternActivity(CommandActivity::class.java)
//        } else if (id == R.id.nav_observer && lifecycleListener.getCurrentActivity() !is WeatherStationActivity) {
//            launchPatternActivity(WeatherStationActivity::class.java)
        } else {
            return false
        }

        val drawer : DrawerLayout = findViewById(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)

        return true;
    }

    protected fun launchPatternActivity(activityToStart: Class<*>) {
        val newActivity = Intent(this.currentActivity(), activityToStart)
        this.startActivity(newActivity)
    }
}