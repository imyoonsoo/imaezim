package com.example.imaezim

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imaezim.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {
    //findbyview 생략 기능 추가
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // 리사이클러뷰 초기화
        val recyclerView : RecyclerView = findViewById(R.id.rv_home)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dataList = generateData()
        val adapter = HomeAdapter(this, dataList)
        recyclerView.adapter = adapter
    }

    private fun generateData() : List<HomeData> {
        val data1 = HomeData("김이주", "3시간 전", R.drawable.img_map_1)
        val data2 = HomeData("박구슬", "2023-11-11", R.drawable.img_map_2)
        val data3 = HomeData("손여린", "2023-10-31", R.drawable.img_map_3)

        return listOf(data1, data2, data3)
    }
}