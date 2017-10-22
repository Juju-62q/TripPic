package com.example.okano.trippic.Fragments


import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.preference.Preference
import android.support.v7.preference.PreferenceFragmentCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.okano.trippic.R


/**
 * A simple [Fragment] subclass.
 * Use the [ConfigFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ConfigFragment : PreferenceFragmentCompat(), Preference.OnPreferenceClickListener, DialogInterface.OnClickListener {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preference, rootKey)
        val allDelete = findPreference("allDelete")
        allDelete.setOnPreferenceClickListener(this)
    }

    override fun onPreferenceClick(preference: Preference?): Boolean {
        val alert = AlertDialog.Builder(activity)
        alert.setTitle("本当に全データを削除しますか？")
        alert.setMessage("復元できません")
        alert.setPositiveButton("確認",this)
        alert.setNegativeButton("キャンセル",this)
        alert.show()

        return false
    }

    override fun onClick(dialog: DialogInterface?, which: Int) {
        if(which == -1){
            //positive button

        }else{
            //negative button
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    companion object {
        fun newInstance(): ConfigFragment {
            val fragment = ConfigFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
