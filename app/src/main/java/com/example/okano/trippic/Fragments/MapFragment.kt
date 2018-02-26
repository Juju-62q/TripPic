package com.example.okano.trippic.Fragments


import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.beardedhen.androidbootstrap.BootstrapButton
import com.example.okano.trippic.MapsActivity
import com.example.okano.trippic.R
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import android.widget.Toast
import com.example.okano.trippic.DB.RealmManager
import com.example.okano.trippic.DB.TripInfoDao


/**
 * A simple [Fragment] subclass.
 * Use the [MapFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MapFragment : Fragment(), OnMapReadyCallback, View.OnClickListener {

    private var mMap : GoogleMap? = null
    var mMapView : MapView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_map, container, false)

        //Button
        val logButton = view.findViewById<BootstrapButton>(R.id.startLog)
        logButton.setOnClickListener(this)

        //val ownPoint = view.findViewById<BootstrapButton>(R.id.ownPoint)
        //ownPoint.setOnClickListener(this)

        //Google Map
        mMapView = view.findViewById(R.id.mapView)
        mMapView!!.onCreate(savedInstanceState)
        mMapView!!.onResume()

        try{
            MapsInitializer.initialize(activity)
        }catch (e : Exception){
            e.printStackTrace()
        }

        mMapView!!.getMapAsync(this)

        return view
    }


    companion object {
        fun newInstance(): MapFragment {
            val fragment = MapFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    // Google Map
    override fun onMapReady(p0: GoogleMap?) {
        mMap = p0

        val sydney = LatLng(25.54,130.5)
        mMap!!.addMarker(MarkerOptions().position(sydney).title("Sydney"))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    override fun onResume() {
        super.onResume()
        mMapView!!.onResume()
    }

    override fun onPause() {
        super.onPause()
        mMapView!!.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mMapView!!.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mMapView!!.onLowMemory()
    }

    // Button
    override fun onClick(v: View?) {
        if (v != null){
            when (v!!.id){
                R.id.startLog -> {
                    startLogClicked(v)
                    return
                }
                /*R.id.ownPoint -> {
                    ownPointClicked(v)
                    return
                }*/
                else -> return
            }
        }
        return
    }

    fun startLogClicked(v: View){
        val intent = Intent(activity, MapsActivity::class.java)

        var dialog = MapDialogFragment()
        dialog.title = "旅行開始"
        dialog.msg = "旅行の名前を入力してください。"
        dialog.onOkClickListener = DialogInterface.OnClickListener({dialog,which ->
            val tripName = (dialog as Dialog).findViewById<EditText>(R.id.tripName).text.toString()
            if(tripName == ""){
                val toast = Toast.makeText(activity, "旅行名を入力してください", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER,0,0)
                toast.show()
            }else {
                val realmManager = RealmManager()
                val tripInfo = TripInfoDao(realmManager.initRealm(activity))
                tripInfo.createTripInfo(dialog.findViewById<EditText>(R.id.tripName).text.toString())
                realmManager.closeRealm()
                startActivity(intent)
            }
        })
        dialog.show(activity.supportFragmentManager,"tag")


        //
        // startActivity(intent)
        return
    }

    /*fun ownPointClicked(v: View){
        return
    }*/
}// Required empty public constructor

