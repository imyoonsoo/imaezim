package com.example.imaezim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imaezim.databinding.ActivityMainBinding

class MyFeedActivity : AppCompatActivity() {
    //findbyview 생략 기능 추가
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myfeed)
    }
}