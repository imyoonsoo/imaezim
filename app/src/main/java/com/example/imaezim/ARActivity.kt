package com.example.imaezim

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imaezim.databinding.ActivityArBinding
import android.content.Intent

class ARActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ar)
        binding = ActivityArBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.homeButtonAr.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.myfeedButtonAr.setOnClickListener {
            val intent = Intent(this, MyFeedActivity::class.java)
            startActivity(intent)
        }
    }
}