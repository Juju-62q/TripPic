package com.example.okano.trippic.DB

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import java.util.*

/**
 * Created by okano on 2017/12/01.
 */
public open class TripInfo(
    @PrimaryKey open var tripId : Long = 0,
    @Required open var tripName : String = "",
    open var startTime : Date? = null,
    open var endTime : Date? = null
): RealmObject(){}