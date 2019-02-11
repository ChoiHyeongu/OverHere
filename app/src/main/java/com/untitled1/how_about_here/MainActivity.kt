package com.untitled1.how_about_here

import android.content.res.ColorStateList
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val homeFragment: Fragment = HomeFragment()
    var fabClicekd = false
    var locationClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(main_container.id, homeFragment).commit()
        main_toolbarTitle.setText(R.string.home_fragment)
        main_bottomHome.setBackgroundColor(resources.getColor(R.color.livingColar))

        main_fab.setOnClickListener {
            if (!fabClicekd) { showFab() }
            else { closeFab() }
        }

        main_fabLocation.setOnClickListener {
            if (!locationClicked) {
                main_fabLocation.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.black))
                main_fabLocation.setImageResource(R.drawable.ic_home_icon)
                Toast.makeText(this, "서울특별시 구로구", Toast.LENGTH_LONG).show()
                locationClicked = true
            } else {
                main_fabLocation.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
                main_fabLocation.setImageResource(R.drawable.ic_local_icon)
                locationClicked = false
            }

            closeFab()
        }

        main_fabAdd.setOnClickListener {

        }

    }

    fun showFab() {
        main_fabLocation.show()
        main_fabAdd.show()
        fabClicekd = true
        main_fab.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.black))
        main_fab.setImageResource(R.drawable.ic_x_icon)
    }

    fun closeFab(){
        main_fab.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
        main_fab.setImageResource(R.drawable.ic_add_friends)
        main_fabAdd.hide()
        main_fabLocation.hide()
        fabClicekd = false
    }
}
