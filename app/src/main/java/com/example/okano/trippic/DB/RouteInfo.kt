package com.example.okano.trippic.DB

import io.realm.RealmObject

/**
 * Created by okano on 2017/12/01.
 */
class RouteInfo : RealmObject() {
    var latitude : Double = 0.0
    var langitude : Double = 0.0
    var time : String = ""
    var picPath : String? = null
    var tripId : Long = 0
}