package com.example.imaezim.retrofit

class User {
    var id: Int = 0
    val email: String = ""
    val password: String = ""
    val nickname: String = ""
}

class Post {
    var userId: Int = 0
    val nickname: String = ""
    val location_type: Int = 0
    val date: String = ""
    val latitude: Float = 0.0F
    val longitude: Float = 0.0F
    val open: String = ""
    val detailAddr: String = ""
}

class MyPost {
    var userId: Int = 0
    val nickname: String = ""
    val location_type: Int = 0
    val date: String = ""
    val latitude: Float = 0.0F
    val longitude: Float = 0.0F
    val open: String = ""
    val detailAddr: String = ""
    val memoType: String = ""
    val text: String = ""
    val picture: String = ""
    val record: String = ""
    val video: String = ""
}