package com.example.imaezim

import MyFeedData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imaezim.databinding.ActivityMyfeedBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MyFeedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyfeedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myfeed)
        binding = ActivityMyfeedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 리사이클러뷰 초기화
        val recyclerView : RecyclerView = findViewById(R.id.rv_myfeed)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dataList = generateData()
        val  adapter = MyFeedAdapter(this, dataList)
        recyclerView.adapter = adapter

        binding.arButtonMyfeed.setOnClickListener {
            val intent = Intent(this, ARActivity::class.java)
            startActivity(intent)
        }

        binding.homeButtonMyfeed.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun generateData() : List<MyFeedData> {
        val data1 = MyFeedData(MyFeedData.MemoType.TEXT, 1, 37.653, 127.0149, "인문대학", text="광화문 첫 방문! 이것저것 구경하고 맛있는 것도...")
        val data2 = MyFeedData(MyFeedData.MemoType.IMAGE, 0, 37.752, 127.115, "어딘가", image = R.drawable.img_myfeed_1)
        val data3 = MyFeedData(MyFeedData.MemoType.VIDEO, 1, 37.554, 127.2148,"수유역", video = R.raw.home)
        //val data4 = MyFeedData(MyFeedData.MemoType.AUDIO, 0, 37.453, 127.2149, "장소테스트", audio = R.raw.sample_1)

        return listOf(data1, data2, data3)
        //return listOf(data1, data2, data3, data4)
    }
}