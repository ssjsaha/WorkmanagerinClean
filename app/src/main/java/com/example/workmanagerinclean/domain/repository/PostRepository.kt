package com.example.workmanagerinclean.domain.repository

import kotlinx.coroutines.flow.Flow

interface PostRepository {
    suspend fun getPost(): Flow<Pair<String,String>>
}