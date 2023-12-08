package com.example.imaezim

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imaezim.databinding.ActivityMainBinding

class ARActivity : AppCompatActivity() {
    //findbyview 생략 기능 추가
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ar)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}