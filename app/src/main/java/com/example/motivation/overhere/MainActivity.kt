package com.example.motivation.overhere

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar_title.text = "큐레이션"
        supportFragmentManager.beginTransaction().add(R.id.main_container, CurationFragment()).commit()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                toolbar_title.text = "큐레이션"
                supportFragmentManager.beginTransaction().replace(R.id.main_container, CurationFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_alert -> {
                toolbar_title.text = "알람"
                supportFragmentManager.beginTransaction().replace(R.id.main_container, AlertFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_plan -> {
                toolbar_title.text = "일정"
                supportFragmentManager.beginTransaction().replace(R.id.main_container, PlanFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_friend -> {
                supportFragmentManager.beginTransaction().replace(R.id.main_container, FriendFragment()).commit()
                toolbar_title.text = "친구"
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}
