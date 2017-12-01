package com.example.okano.trippic.DB

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import java.util.*

/**
 * Created by okano on 2017/12/01.
 */
open class TripInfo(
        @PrimaryKey
        open var tripId : Long,
        @Required
        open var tripName : String,
        open var startTime : String?,
        open var endTime : String?
    ) : RealmObject(){}