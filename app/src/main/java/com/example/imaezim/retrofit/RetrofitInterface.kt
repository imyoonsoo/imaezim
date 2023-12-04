package com.example.imaezim.retrofit

import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*

interface UserService {
    @get : GET("/common/user_drf/")
    val getUser: Call<List<User>>

    @FormUrlEncoded
    @POST("/common/user_drf/")
    fun postUser(
        @Field("email") email : String,
        @Field("password") password : String,
        @Field("nickname") nickname : String,
    ) : Call<JSONObject>

    @FormUrlEncoded
    @POST("/common/user/")
    fun getUserInf(
        @Field("email") email : String,   //email 입력 받아서 해당 유저만 정보 가져오기
    ) : Call<List<User>>
}
