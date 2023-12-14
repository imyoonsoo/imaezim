// MyFeedAdapter.kt
package com.example.imaezim

import MyFeedData
import android.content.Context
import android.media.MediaMetadataRetriever
import android.media.MediaPlayer
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.squareup.picasso.Picasso

class MyFeedAdapter(private val context: Context, private val itemList: List<MyFeedData>) :
    RecyclerView.Adapter<MyFeedAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), OnMapReadyCallback {
        val text: TextView = view.findViewById(R.id.text)
        val image: ImageView = view.findViewById(R.id.image)
        val video: VideoView = view.findViewById(R.id.video)
        val videoImage: ImageView = view.findViewById(R.id.videoImage)
        val audio: ImageButton = view.findViewById(R.id.audio)
        val time : TextView = view.findViewById(R.id.time)
        val divider: View = view.findViewById(R.id.divider)
        val mapView: MapView = view.findViewById(R.id.map)

        private lateinit var map: GoogleMap
        lateinit var latLng: LatLng
        var inout: Int = 2
        var color = BitmapDescriptorFactory.HUE_YELLOW
        lateinit var addr: String

        init {
            with(mapView) {
                onCreate(null)
                getMapAsync(this@ViewHolder)
            }
        }


        fun setMapLocation() {
            if (!::map.isInitialized) return
            with(map) {
                moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))
                when (inout) {
                    1 -> color =BitmapDescriptorFactory.HUE_VIOLET
                    0 -> color =BitmapDescriptorFactory.HUE_ORANGE
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_myfeed, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        //holder.map.setImageResource(item.map)
        holder.time.text = item.time
        holder.inout = item.inout
        holder.latLng = LatLng(item.lat, item.lng)
        holder.addr = item.addressDetail
        holder.setMapLocation()
        when (item.memoType) {
            MyFeedData.MemoType.TEXT -> {
                holder.text.text = item.text
                holder.text.visibility = View.VISIBLE
                holder.image.visibility = View.GONE
                holder.video.visibility = View.GONE
                holder.videoImage.visibility = View.GONE
                holder.audio.visibility = View.GONE
                //holder.mapView.visibility = View.VISIBLE
            }

            MyFeedData.MemoType.IMAGE -> {
                Picasso.get()
                    .load("http://34.64.197.160:8000" + item.image)
                    .error(R.drawable.img_myfeed_1)
                    .into(holder.image);
                //holder.image.setImageResource(item.image)
                holder.text.visibility = View.GONE
                holder.video.visibility = View.GONE
                holder.videoImage.visibility = View.GONE
                holder.audio.visibility = View.GONE
            }

            MyFeedData.MemoType.VIDEO -> {
//                // 비디오 썸네일 생성
//                val retriever = MediaMetadataRetriever();
//                retriever.setDataSource(context, Uri.parse("android.resource://" + context.packageName + "/" + R.raw.home))
//                val bitmap = retriever.getFrameAtTime(0, MediaMetadataRetriever.OPTION_CLOSEST_SYNC)
//                retriever.release()
//
//                // 비디오 썸네일을 ImageView에 설정
//                holder.videoImage.setImageBitmap(bitmap)

                // 비디오 클릭 시 재생
//                holder.videoImage.setOnClickListener{
//                    holder.video.visibility = View.VISIBLE
//                    val videoUri = Uri.parse("android.resource://" + context.packageName + "/" + R.raw.home)
//                    holder.video.setVideoURI(videoUri)
//                    holder.video.start()
//                }
                holder.videoImage.visibility = View.VISIBLE
                holder.text.visibility = View.GONE
                holder.image.visibility = View.GONE
                holder.audio.visibility = View.GONE
            }

            MyFeedData.MemoType.AUDIO -> {
                holder.audio.visibility = View.VISIBLE
                // 오디오 클릭 시 재생
//                holder.audio.setOnClickListener {
//                    val audioUri = Uri.parse("android.resource://" + context.packageName + "/" + R.raw.sample_1)
//                    val mediaPlayer = MediaPlayer()
//                    mediaPlayer.setDataSource(context, audioUri)
//                    mediaPlayer.prepare()
//                    mediaPlayer.start()
//                }
                holder.text.visibility = View.GONE
                holder.image.visibility = View.GONE
                holder.video.visibility = View.GONE
                holder.videoImage.visibility = View.GONE
            }
        }
        if (position < itemList.size - 1)
            holder.divider.visibility = View.VISIBLE
        else
            holder.divider.visibility = View.GONE
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}