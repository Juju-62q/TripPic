package com.example.okano.trippic.DB

import android.content.Context
import io.realm.Realm

/**
 * Created by okano on 2017/12/01.
 */
class RealmManager {
    private lateinit var mRealm : Realm
    lateinit var routeInfoDao : RouteInfoDao
    lateinit var tripInfoDao : TripInfoDao

    fun initRealm (context: Context){
        Realm.init(context)
        mRealm = Realm.getDefaultInstance()
        tripInfoDao = TripInfoDao(mRealm)
        routeInfoDao = RouteInfoDao(mRealm)
    }

    fun closeRealm(){
        mRealm.close()
    }
}