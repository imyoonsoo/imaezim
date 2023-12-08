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
        val data1 = MyFeedData(MyFeedData.MemoType.TEXT, text="광화문 첫 방문! 이것저것 구경하고 맛있는 것도...", map = R.drawable.img_map_1)
        val data2 = MyFeedData(MyFeedData.MemoType.IMAGE, image = R.drawable.img_myfeed_1, map = R.drawable.img_map_2)
        val data3 = MyFeedData(MyFeedData.MemoType.VIDEO, video = R.raw.home, map = R.drawable.img_map_3)
        val data4 = MyFeedData(MyFeedData.MemoType.AUDIO, audio = R.raw.sample_1, map = R.drawable.img_map_1)

        return listOf(data1, data2, data3, data4)
    }
}