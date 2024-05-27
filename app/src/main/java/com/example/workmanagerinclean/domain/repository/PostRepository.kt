package com.example.workmanagerinclean.domain.repository

import androidx.work.WorkInfo
import com.google.common.util.concurrent.ListenableFuture
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    suspend fun getPost(): Flow<WorkInfo>
}