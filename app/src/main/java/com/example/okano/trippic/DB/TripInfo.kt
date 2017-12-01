package com.example.okano.trippic.DB

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

/**
 * Created by okano on 2017/12/01.
 */
class TripInfo : RealmObject(){
    @PrimaryKey var tripId : Long = 0
    @Required var tripName : String = ""
    var startTime : String? = null
    var endTime : String? = null
}