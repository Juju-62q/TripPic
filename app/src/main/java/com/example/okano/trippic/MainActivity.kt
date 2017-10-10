package com.example.okano.trippic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import com.example.okano.trippic.Fragments.PageAdapter


class MainActivity : AppCompatActivity() {
    private var pageAdapter: PageAdapter? = null
    private var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        pageAdapter = PageAdapter(supportFragmentManager)

        viewPager = findViewById<ViewPager>(R.id.viewpager)
        viewPager!!.adapter = pageAdapter

        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_home_black_24dp)
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_map_black_24dp)
        tabLayout.getTabAt(2)!!.setIcon(R.drawable.ic_settings_black_24dp)

    }

}
