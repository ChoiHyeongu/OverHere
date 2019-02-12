package com.untitled1.how_about_here

import android.content.res.ColorStateList
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Build
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuInflater


class MainActivity : AppCompatActivity() {

    private val homeFragment: Fragment = HomeFragment()
    private val AlertFragment: Fragment = AlertFragment()
    var fabClicekd = false
    var locationClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val statusBar = window.decorView

        if (Build.VERSION.SDK_INT >= 23) {
            window.statusBarColor = Color.WHITE
            statusBar.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        supportFragmentManager.beginTransaction().add(main_container.id, homeFragment).commit()
        main_toolbarTitle.setText(R.string.home_fragment)
        main_bottomHomeLayout.setBackgroundColor(resources.getColor(R.color.livingColar))

        main_fab.setOnClickListener {
            if (!fabClicekd) {
                showFab()
            } else {
                closeFab()
            }
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)

        val search = menu!!.findItem(R.id.action_search)
        val searchView: SearchView = search.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })

        return true
    }

    fun bottomMenuClicked(v: View) {
        when (v.id) {
            R.id.main_bottomHome -> startHome()
            R.id.main_bottomAlert -> startAlert()
        }
    }

    fun showFab() {
        main_fabLocation.show()
        main_fabAdd.show()
        fabClicekd = true
        main_fab.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.black))
        main_fab.setImageResource(R.drawable.ic_x_icon)
    }

    fun closeFab() {
        main_fab.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
        main_fab.setImageResource(R.drawable.ic_add_friends)
        main_fabAdd.hide()
        main_fabLocation.hide()
        fabClicekd = false
    }

    fun startHome() {
        supportFragmentManager.beginTransaction().replace(main_container.id, homeFragment).commit()
        main_bottomHomeLayout.setBackgroundColor(resources.getColor(R.color.livingColar))
        main_bottomAlerteLayout.setBackgroundColor(resources.getColor(R.color.black))
        main_bottomFriendLayout.setBackgroundColor(resources.getColor(R.color.black))
        main_bottomPlanLayout.setBackgroundColor(resources.getColor(R.color.black))
    }

    fun startAlert() {
        supportFragmentManager.beginTransaction().replace(main_container.id, AlertFragment).commit()
        main_bottomHomeLayout.setBackgroundColor(resources.getColor(R.color.black))
        main_bottomAlerteLayout.setBackgroundColor(resources.getColor(R.color.livingColar))
        main_bottomFriendLayout.setBackgroundColor(resources.getColor(R.color.black))
        main_bottomPlanLayout.setBackgroundColor(resources.getColor(R.color.black))
    }
}
