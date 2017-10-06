package com.example.okano.trippic.Fragments


import android.graphics.Camera
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.okano.trippic.R
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

/**
 * A simple [Fragment] subclass.
 * Use the [MapFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MapFragment : Fragment(), OnMapReadyCallback {

    private var mMap : GoogleMap? = null
    var mMapView : MapView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_map, container, false)

        mMapView = view.findViewById(R.id.mapView)
        mMapView!!.onCreate(savedInstanceState)

        mMapView!!.onResume()

        try{
            MapsInitializer.initialize(activity.applicationContext)
        }catch (e : Exception){
            e.printStackTrace()
        }

        mMapView!!.getMapAsync(this)

        return view
    }


    companion object {
        fun newInstance(param1: String, param2: String): MapFragment {
            val fragment = MapFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

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
}// Required empty public constructor
