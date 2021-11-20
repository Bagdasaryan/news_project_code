package com.example.feature_main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeActivity : AppCompatActivity() {
    var detailNewsTitle = ""
    var detailNewsDescription = ""
    var detailNewsIconLinc = ""

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_content, fragment)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val toolbar = supportActionBar;

        loadFragment(HomeFragment.newInstance())

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.fl_navigation)

        bottomNavigation.setOnItemSelectedListener { item ->
            var fragment: Fragment
            when (item.itemId) {
                R.id.navigation_home -> {
                    toolbar!!.title = "Home"
                    fragment = HomeFragment()
                    loadFragment(fragment)
                    true
                }
//            R.id.navigation_dashboard -> {
//                loadFragment(DashboardFragment().newInstance())
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_notifications -> {
//                loadFragment(NotificationsFragment().newInstance())
//                return@OnNavigationItemSelectedListener true
//            }
            }
            false
        }
    }
}
