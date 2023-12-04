package com.example.imaezim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.imaezim.databinding.ActivityJoinBinding
import com.example.imaezim.retrofit.User
import com.example.imaezim.retrofit.UserService
import com.example.projecttest.retrofit.RetrofitClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JoinActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)
        binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //회원가입 버튼 클릭시
        fun join() {
            var email_input = binding.joinEmailAddress.text.toString()
            var password_input = binding.joinPassword.text.toString()
            var password_input2 = binding.joinPassword2.text.toString()
            var nickname_input = binding.joinNickname.text.toString()


            if (nickname_input == "") Toast.makeText(this@JoinActivity, "닉네임 입력해주세요", Toast.LENGTH_SHORT).show()
            else if (email_input == "") Toast.makeText(this@JoinActivity, "이메일 입력해주세요", Toast.LENGTH_SHORT).show()
            else if (password_input == "") Toast.makeText(this@JoinActivity, "비밀번호 입력해주세요", Toast.LENGTH_SHORT).show()
            else if (password_input2 == "") Toast.makeText(this@JoinActivity, "비밀번호 입력해주세요", Toast.LENGTH_SHORT).show()
            else if (password_input != password_input2) Toast.makeText(this@JoinActivity, "비밀번호가  일치하지않습니다", Toast.LENGTH_SHORT).show()
            else if (nickname_input == "") Toast.makeText(this@JoinActivity, "닉네임 입력해주세요", Toast.LENGTH_SHORT).show()
            else if (true) {
                //Toast.makeText(this@JoinActivity, "성공", Toast.LENGTH_SHORT).show()
                val UserService = RetrofitClient.getClient()?.create(UserService::class.java)

                val call = UserService!!.postUser(
                    email_input,
                    password_input,
                    nickname_input,
                )
                call.enqueue(object : Callback<JSONObject> {
                    override fun onResponse(
                        call: Call<JSONObject>,
                        response: Response<JSONObject>
                    ) {
                        if (!response.isSuccessful) {
                            //textView.setText("Code: " + response.code())
                            return
                        }
                        val data = response.body()

                        //val UserService = RetrofitClient.getClient()?.create(UserService::class.java)
                        val call2 = UserService!!.getUserInf(email_input)
                        call2.enqueue(object : Callback<List<User>> {
                            override fun onResponse(
                                call: Call<List<User>>,
                                response: Response<List<User>>
                            ) {
                                if (!response.isSuccessful) {
                                    return
                                }
                                lateinit var data_list: List<User>
                                data_list = response.body()!!
                                for (data in data_list) {
                                }
                                for (data in data_list) {
                                    LoginUser.id = data.id
                                    LoginUser.email = data.email
                                    LoginUser.password = data.password
                                    LoginUser.nickname = data.nickname
                                }
                                //Toast.makeText(this@JoinActivity, LoginUser.id.toString() , Toast.LENGTH_SHORT).show()
                                //Toast.makeText(this@JoinActivity, LoginUser.email , Toast.LENGTH_SHORT).show()
                                //Toast.makeText(this@JoinActivity, LoginUser.password , Toast.LENGTH_SHORT).show()
                                //Toast.makeText(this@JoinActivity, LoginUser.nickname , Toast.LENGTH_SHORT).show()
                                //Toast.makeText(this@JoinActivity, LoginUser.restaurant_on.toString() , Toast.LENGTH_SHORT).show()

                                //회원가입 & 회원가입한 user 정보 얻기 성공시 페이지 이동
                                //로그인 성공시 화면 전환
                                val intent = Intent(this@JoinActivity, JoinActivity::class.java)
                                startActivity(intent)
                            }
                            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                                Log.d("Debug", "onFailure 실행$t")
                            }
                        })
                    }
                    override fun onFailure(call: Call<JSONObject>, t: Throwable) {
                        //textView.setText(t.message)
                        Log.d("Debug", "onFailure 실행$t")
                    }
                })
            }

        }

        //회원가입 버튼 클릭
        binding.finalJoinButton.setOnClickListener {
            join()
        }

        binding.backButtonJoin.setOnClickListener {
            finish()
        }
    }
}