// MyFeedAdapter.kt
package com.example.imaezim

import MyFeedData
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView

class MyFeedAdapter(private val context: Context, private val itemList: List<MyFeedData>) :
    RecyclerView.Adapter<MyFeedAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text: TextView = view.findViewById(R.id.text)
        val image: ImageView = view.findViewById(R.id.image)
        val video: VideoView = view.findViewById(R.id.video)
        val audio: ImageButton = view.findViewById(R.id.audio)
        val map: ImageView = view.findViewById(R.id.map)
        val divider: View = view.findViewById(R.id.divider)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_myfeed, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.map.setImageResource(item.map)

        when (item.memoType) {
            MyFeedData.MemoType.TEXT -> {
                holder.text.text = item.text
                holder.text.visibility = View.VISIBLE
                holder.image.visibility = View.GONE
                holder.video.visibility = View.GONE
                holder.audio.visibility = View.GONE
                holder.map.visibility = View.VISIBLE
            }

            MyFeedData.MemoType.IMAGE -> {
                holder.image.setImageResource(item.image)
                holder.text.visibility = View.GONE
                holder.video.visibility = View.GONE
                holder.audio.visibility = View.GONE
            }

            MyFeedData.MemoType.VIDEO -> {
                holder.video.visibility = View.VISIBLE
                holder.video.setVideoURI(Uri.parse("android.resource://" + context.packageName + "/" + item.video))
                holder.text.visibility = View.GONE
                holder.image.visibility = View.GONE
                holder.audio.visibility = View.GONE
            }

            MyFeedData.MemoType.AUDIO -> {
                holder.audio.visibility = View.VISIBLE
                holder.text.visibility = View.GONE
                holder.image.visibility = View.GONE
                holder.video.visibility = View.GONE
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