package com.example.imaezim

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class HomeAdapter(private val context: Context, private val itemList: List<HomeData>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    // ViewHolder Class
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), OnMapReadyCallback {
        val who : TextView = view.findViewById(R.id.who)
        val time : TextView = view.findViewById(R.id.time)
        val mapView : MapView = view.findViewById(R.id.mapView)
        val divider : View = view.findViewById(R.id.divider)

        private lateinit var map : GoogleMap
        lateinit var latLng: LatLng
        var inout : Int = 2
        var color = BitmapDescriptorFactory.HUE_YELLOW
        lateinit var addr : String

        init{
            with(mapView){
                onCreate(null)
                getMapAsync(this@ViewHolder)
            }
        }

        fun setMapLocation() {
            if (!::map.isInitialized) return
            with(map) {
                moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))
                when(inout){
                    1 -> color = BitmapDescriptorFactory.HUE_VIOLET
                    0 -> color = BitmapDescriptorFactory.HUE_ORANGE
                }

                addMarker(
                    MarkerOptions().position(latLng).title(addr).icon(
                        BitmapDescriptorFactory.defaultMarker(color)
                    )
                )
                mapType = GoogleMap.MAP_TYPE_NORMAL
            }
        }
        override fun onMapReady(googleMap: GoogleMap) {
            MapsInitializer.initialize(context)
            map = googleMap ?: return
            setMapLocation()
        }

        fun clearView() {
            with(map) {
                clear()
                mapType = GoogleMap.MAP_TYPE_NONE
            }
        }


    }

    // 뷰홀더 객체 onCreateViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_home, parent, false)
        return ViewHolder(view)
    }

    // 뷰홀더에 데이터 바인딩
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        val whoString = "${item.who}님이 게시글을 공유했습니다.\n방문하여 확인하세요!"

        holder.who.text = whoString
        holder.time.text = item.time
        holder.inout = item.inout
        holder.latLng = LatLng(item.lat, item.lng)
        holder.addr = item.addressDetail
        holder.setMapLocation()

        // 마지막 항목일 경우 구분선 X
        if(position<itemList.size-1)
            holder.divider.visibility = View.VISIBLE
        else
            holder.divider.visibility = View.GONE
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}