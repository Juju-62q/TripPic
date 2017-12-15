package com.example.okano.trippic.Fragments

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.support.v4.app.DialogFragment
import android.content.DialogInterface
import android.os.Bundle
import com.example.okano.trippic.R

/**
 * Created by okano on 2017/12/08.
 */
class MapDialogFragment(): DialogFragment() {

    var title = "title"
    var msg = "msg"
    var okText = "OK"
    var cancelText = "cancel"
    /** ok押下時の挙動 */
    var onOkClickListener : DialogInterface.OnClickListener? = null
    /** cancel押下時の挙動 デフォルトでは何もしない */
    var onCancelClickListener : DialogInterface.OnClickListener? = DialogInterface.OnClickListener { _, _ -> }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the Builder class for convenient dialog construction
        val builder = AlertDialog.Builder(activity)
        val inflater = activity.layoutInflater
        builder.setTitle(title)
                .setMessage(msg)
                .setView(inflater.inflate(R.layout.map_dialog, null))
                .setPositiveButton(okText, onOkClickListener)
                .setNegativeButton(cancelText, onCancelClickListener)
        // Create the AlertDialog object and return it
        return builder.create()
    }

}