package com.example.motivation.overhere

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.main_container, CurationFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_alert -> {
                supportFragmentManager.beginTransaction().replace(R.id.main_container, AlertFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_plan -> {

                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_friend -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.main_container, CurationFragment()).commit()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
