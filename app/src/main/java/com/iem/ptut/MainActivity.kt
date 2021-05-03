package com.iem.ptut

import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

lateinit var toolbar: MaterialToolbar
    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.main_activity_toolbar)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_activity_nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        bottomNavigationView = findViewById(R.id.main_bottom_navigation_view)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.main_navigation_item_home -> {
                    navController.navigate(R.id.main_navigation_homeFragment)
                    true
                }
                R.id.main_navigation_item_cdc -> {
                    navController.navigate(R.id.main_navigation_guidesFragment)
                    true
                }
                R.id.main_navigation_item_news -> {
                    navController.navigate(R.id.main_navigation_newsFragment)
                    true
                }
                else -> false
            }

        }

        toolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.main_appbar_profile -> {
                    // TODO : Handle profile on click action
                    true
                }
                else -> false

            }
        }


    }
}