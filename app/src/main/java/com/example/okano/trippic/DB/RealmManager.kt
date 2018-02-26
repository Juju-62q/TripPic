package com.example.okano.trippic.DB

import android.content.Context
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by okano on 2017/12/01.
 */
class RealmManager {
    private lateinit var mRealm : Realm

    fun initRealm (context: Context):Realm{

        Realm.init(context)

        val realmConfig = RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build()

        mRealm = Realm.getInstance(realmConfig)

        return mRealm
    }

    fun closeRealm(){
        mRealm.close()
    }
}