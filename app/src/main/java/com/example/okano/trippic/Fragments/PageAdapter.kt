package com.example.okano.trippic.Fragments

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by okano on 2017/09/18.
 */
class PageAdapter(fm: FragmentManager) :FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        when (position){
            0 -> return StartFragment.newInstance("","")
            1 -> return MapFragment.newInstance("","")
            else -> return ConfigFragment.newInstance("","")
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        when (position){
            0 -> return "Start"
            1 -> return "Map"
            else -> return "Config"
        }
    }
}