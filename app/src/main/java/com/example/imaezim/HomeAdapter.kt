package com.example.imaezim

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter(private val context: Context, private val itemList: List<HomeData>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    // ViewHolder Class
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val who : TextView = view.findViewById(R.id.who)
        val time : TextView = view.findViewById(R.id.time)
        val map : ImageView = view.findViewById(R.id.map)
    }

    // 뷰홀더 객체 onCreateViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_home, parent, false)
        return ViewHolder(view)
    }

    // 뷰홀더에 데이터 바인딩
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        val whoString = "${item.who}님이 게시글을 공유했습니다. 방문하여 확인하세요!"

        holder.who.text = whoString
        holder.time.text = item.time
        holder.map.setImageResource(item.map)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
