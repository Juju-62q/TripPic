package com.example.okano.trippic.GPS

import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat
import android.Manifest;
import android.app.Activity
import android.support.v4.app.ActivityCompat

/**
 * Created by okano on 2017/10/23.
 */
class GPSPermmissionSetting (activity: Activity ){
    var activity : Activity = activity
    private val REQUEST_PERMISSION = 1000

    public fun checkGPSPermission(){
        if(!(ContextCompat.checkSelfPermission(activity,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)){
            requestLocationPermission();
        }
    }

    private fun requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            ActivityCompat.requestPermissions(activity,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_PERMISSION)
        }
    }
}