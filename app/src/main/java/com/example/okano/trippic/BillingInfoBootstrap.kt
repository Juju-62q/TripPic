package com.example.okano.trippic

import android.app.Application
import com.beardedhen.androidbootstrap.TypefaceProvider

/**
 * Created by okano on 2017/10/20.
 */
class BillingInfoBootstrap : Application() {
    override fun onCreate() {
        super.onCreate()
        TypefaceProvider.registerDefaultIconSets()
    }
}