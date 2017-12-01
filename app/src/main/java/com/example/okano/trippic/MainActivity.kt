package com.example.okano.trippic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import com.example.okano.trippic.Fragments.PageAdapter
import com.example.okano.trippic.GPS.GPSPermmissionSetting
import com.example.okano.trippic.DB.RealmManager
import com.example.okano.trippic.DB.TripInfo
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability

class MainActivity : AppCompatActivity() {
    private var pageAdapter: PageAdapter? = null
    private var viewPager: ViewPager? = null
    private lateinit var realmManager : RealmManager

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
        tabLayout.getTabAt(0)!!.setIcon(R.drawable.tab_icon_selector_home)
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.tab_icon_selector_map)
        tabLayout.getTabAt(2)!!.setIcon(R.drawable.tab_icon_selector_setting)

        // check gps permission
        val gpsPermmissionSetting = GPSPermmissionSetting(this)
        gpsPermmissionSetting.checkGPSPermission()

        //check google api
        val resultCode = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this)
        if(resultCode != ConnectionResult.SUCCESS){
            GoogleApiAvailability.getInstance().getErrorDialog(this, resultCode, 0).show()
        }

        realmManager = RealmManager()
        realmManager.initRealm(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        realmManager.closeRealm()
    }

}
