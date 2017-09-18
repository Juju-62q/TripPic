package com.example.okano.trippic

import android.graphics.pdf.PdfDocument
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.View
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

    }
}
