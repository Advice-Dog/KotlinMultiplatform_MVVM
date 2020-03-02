package com.jarroyo.kmp_mvvm

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jarroyo.kmp_mvvm.ui.HomeAdapter
import com.jarroyo.sharedcode.viewModel.HackerTrackerViewModel
import com.jarroyo.sharedcode.viewModel.github.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.container, HomeFragment(), null).commit()
        }

        nav_view.setNavigationItemSelectedListener {
            val fragment = when(it.itemId) {
                R.id.nav_home -> HomeFragment()
                R.id.nav_schedule -> ScheduleFragment()
                else -> HomeFragment()
            }

            supportFragmentManager.beginTransaction().replace(R.id.container, fragment, null).commit()

            drawer_layout.closeDrawers()

            true
        }

    }
}
