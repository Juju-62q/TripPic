package com.example.okano.trippic.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
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
class ConfigFragment : PreferenceFragmentCompat() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
        }
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {

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
