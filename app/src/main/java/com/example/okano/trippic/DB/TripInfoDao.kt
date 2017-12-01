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
        mRealm.beginTransaction()
        var test = mRealm.createObject(TripInfo::class.java, 1)
            //test.tripId = 1
        test.tripName = "test"
        mRealm.commitTransaction()
        val props: RealmResults<TripInfo> = mRealm.where(TripInfo::class.java).findAll()
        val i = 0

    }
}