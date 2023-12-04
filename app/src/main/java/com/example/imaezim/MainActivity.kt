package com.example.imaezim

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imaezim.databinding.ActivityMainBinding
import com.example.imaezim.retrofit.User
import com.example.imaezim.retrofit.UserService
import com.example.projecttest.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    //findbyview 생략 기능 추가
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //findbyview 생략 기능 추가
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userService = RetrofitClient.getClient()?.create(UserService::class.java)

        //로그인 화면
        fun login(email_input: String, password_input: String) {
            lateinit var data_list: List<User>  //User받을 곳

            val call = userService!!.getUser
            call.enqueue(object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    if (!response.isSuccessful) {
                        return
                    }
                    data_list = response.body()!!
                    for (data in data_list) {
                        if (email_input.equals(data.email)) {
                            if (password_input.equals(data.password)) {
                                //로그인한 유저의 정보 LoginUser에 저장하기
                                LoginUser.id = data.id
                                LoginUser.email = data.email
                                LoginUser.password = data.password
                                LoginUser.nickname = data.nickname
                                //Toast.makeText(this@MainActivity, "로그인 성공!!!", Toast.LENGTH_SHORT).show()

                                //로그인 성공시 화면 전환
                                val intent = Intent(this@MainActivity, JoinActivity::class.java)
                                startActivity(intent)
                                return
                            } else {
                                Toast.makeText(this@MainActivity, "비밀번호 오류", Toast.LENGTH_SHORT).show()
                                return
                            }
                        }
                    }
                    Toast.makeText(this@MainActivity, "아이디 오류", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    //textView.setText(t.message)
                    Log.d("Debug", "onFailure 실행$t")
                }
            })
        }

        //로그인 버튼 클릭시
        binding.loginButton.setOnClickListener {
            var email_input = binding.editTextEmailAddress.text.toString()
            var password_input = binding.editTextPassword.text.toString()
            login(email_input, password_input)
        }

        //회원가입 화면 전환
        binding.joinButton.setOnClickListener {
            val intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
        }

    }
}
