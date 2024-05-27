package com.example.workmanagerinclean.data.remote

import com.example.workmanagerinclean.domain.response_model.Post
import retrofit2.Response
import retrofit2.http.GET


interface Api {

    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>
}