package com.example.imaezim

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imaezim.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 리사이클러뷰 초기화
        val recyclerView : RecyclerView = findViewById(R.id.rv_home)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dataList = generateData()
        val adapter = HomeAdapter(this, dataList)
        recyclerView.adapter = adapter

        binding.arButtonHome.setOnClickListener {
            val intent = Intent(this, ARActivity::class.java)
            startActivity(intent)
        }

        binding.myfeedButtonHome.setOnClickListener {
            val intent = Intent(this, MyFeedActivity::class.java)
            startActivity(intent)
        }
    }

    private fun generateData() : List<HomeData> {
        val data1 = HomeData("김이주", "3시간 전", R.drawable.img_map_1)
        val data2 = HomeData("박구슬", "2023-11-11", R.drawable.img_map_2)
        val data3 = HomeData("손여린", "2023-10-31", R.drawable.img_map_3)

        return listOf(data1, data2, data3)
    }
}