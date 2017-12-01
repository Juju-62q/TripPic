package com.example.okano.trippic.DB

import android.content.Context
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmResults

/**
 * Created by okano on 2017/12/01.
 */
class RealmManager {
    private lateinit var mRealm : Realm
    //private lateinit var realmConfig : RealmConfiguration
    lateinit var routeInfoDao : RouteInfoDao
    lateinit var tripInfoDao : TripInfoDao

    fun initRealm (context: Context){
        //val realmConfig = RealmConfiguration.Builder(context).build()
        Realm.init(context)
        mRealm = Realm.getDefaultInstance()

        tripInfoDao = TripInfoDao(mRealm)
        routeInfoDao = RouteInfoDao(mRealm)

        tripInfoDao.test()
    }

    fun closeRealm(){
        mRealm.close()
    }
}