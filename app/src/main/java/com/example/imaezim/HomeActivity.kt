package com.example.imaezim

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imaezim.databinding.ActivityHomeBinding
import com.example.imaezim.retrofit.Post
import com.example.imaezim.retrofit.PostService
import com.example.projecttest.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 리사이클러뷰 초기화
//        val recyclerView : RecyclerView = findViewById(R.id.rv_home)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        val dataList = generateData()
//        val adapter = HomeAdapter(this, dataList)
//        recyclerView.adapter = adapter

        binding.arButtonHome.setOnClickListener {
            val intent = Intent(this, ARActivity::class.java)
            startActivity(intent)
        }

        binding.myfeedButtonHome.setOnClickListener {
            val intent = Intent(this, MyFeedActivity::class.java)
            startActivity(intent)
        }

        fun calculationTime(dateTime: String): String {
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
            val parsedDateTime = LocalDateTime.parse(dateTime, formatter)
            val seoulZoneId = ZoneId.of("Asia/Seoul")
            val now = ZonedDateTime.now(seoulZoneId).toLocalDateTime()
            val difference = ChronoUnit.SECONDS.between(parsedDateTime, now)

            return when {
                difference < 60 -> "방금 전"
                difference < 3600 -> "${difference / 60}분 전"
                difference < 86400 -> "${difference / 3600}시간 전"
                else -> parsedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            }
        }

        val postService = RetrofitClient.getClient()?.create(PostService::class.java)

        fun homePost() {
            lateinit var postList: List<Post>
            val call = postService!!.getPost
            call.enqueue(object : Callback<List<Post>> {
                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    if (!response.isSuccessful) return
                    postList = response.body()!!
                    val postDataList = mutableListOf<HomeData>()

                    for (post in postList) {
                        postDataList.add(
                            HomeData(
                                post.nickname,
                                calculationTime(post.date),
                                post.location_type,
                                post.latitude.toDouble(),
                                post.longitude.toDouble(),
                                post.detailAddr
                            )
                        )
                    }
                    //어댑터 연결
                    val recyclerView : RecyclerView = findViewById(R.id.rv_home)
                    recyclerView.layoutManager = LinearLayoutManager(this@HomeActivity)
                    recyclerView.adapter = HomeAdapter(this@HomeActivity, postDataList)
                }
                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                    Log.d("Debug", "onFailure 실행$t")
                }
            })
        }
        homePost()
    }

    private fun generateData() : List<HomeData> {

        val data1 = HomeData("김이주", "3시간 전", 1, 37.653, 127.0149, "인문대학")
        val data2 = HomeData("박구슬", "2023-11-11", 0, 37.752, 127.115, "어딘가")
        val data3 = HomeData("손여린", "2023-10-31", 1, 37.554, 127.2148,"수유역")

        return listOf(data1, data2, data3)
    }
}