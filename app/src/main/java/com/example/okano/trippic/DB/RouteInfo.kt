package com.example.okano.trippic.DB

import io.realm.RealmObject

/**
 * Created by okano on 2017/12/01.
 */
open class RouteInfo(
    open var latitude : Double = 0.0,
    open var langitude : Double = 0.0,
    open var time : String = "",
    open var picPath : String? = null,
    open var tripId : Long = 0
    ) : RealmObject () {}