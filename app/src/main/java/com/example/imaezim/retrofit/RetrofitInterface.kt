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

interface PostService {
    @get : GET("/sns/feed/")
    val getPost: Call<List<Post>>

//    @FormUrlEncoded
//    @POST("/sns/mypage/")
//    fun getMyPost(
//        @Field("userId") userId : Int   //id로 해당 유저 post만 가져오기
//    ) : Call<List<MyPost>>
    @GET("/sns/mypage/") // 엔드포인트 URL 수정
    fun getMyPost(
        @Query("userId") userId: Int // 쿼리 파라미터로 변경
    ): Call<List<MyPost>>
}