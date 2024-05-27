package com.example.workmanagerinclean.domain.response_model

data class Post(
    val id: Long,
    val title: String,
    val body: String,
    val userId: Long
)
