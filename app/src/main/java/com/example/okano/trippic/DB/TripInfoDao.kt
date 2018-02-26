package com.example.okano.trippic.DB

import io.realm.Realm
import java.util.*

/**
 * Created by okano on 2017/12/01.
 */
class TripInfoDao(realm : Realm) {
    private var mRealm : Realm = realm

    fun createTripInfo(tripName : String){

        // make new trip Id
        var tripId = 1
        val maxTripId = mRealm.where(TripInfo::class.java).max("tripId")
        if (maxTripId != null){
            tripId = maxTripId.toInt() + 1
        }

        // create data
        mRealm.executeTransaction {
            var tripInfo = mRealm.createObject(TripInfo::class.java, tripId)
            tripInfo.tripName = tripName
            tripInfo.startTime = Date()
            mRealm.copyToRealm(tripInfo)
        }
    }
}