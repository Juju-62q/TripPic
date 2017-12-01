package com.example.okano.trippic.DB

import io.realm.Realm
import io.realm.RealmResults
import java.util.*

/**
 * Created by okano on 2017/12/01.
 */
class TripInfoDao(realm : Realm) {
    private var mRealm : Realm = realm

    fun test(){
        var test = TripInfo(tripId = 23, tripName = "test")


        mRealm.executeTransaction {
            mRealm.insertOrUpdate(test)
        }
        val props: RealmResults<TripInfo> = mRealm.where(TripInfo::class.java).findAll()
    }
}