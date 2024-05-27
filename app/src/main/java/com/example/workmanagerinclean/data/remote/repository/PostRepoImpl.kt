package com.example.workmanagerinclean.data.remote.repository

import androidx.lifecycle.asFlow
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.workmanagerinclean.data.remote.GetPostWorker
import com.example.workmanagerinclean.domain.repository.PostRepository
import com.google.common.util.concurrent.ListenableFuture
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostRepoImpl @Inject constructor(private val workManager: WorkManager) : PostRepository {
    override suspend fun getPost(): Flow<WorkInfo> {
        val getPostWorkRequest: OneTimeWorkRequest =
            OneTimeWorkRequest.Builder(GetPostWorker::class.java).build()
        workManager.enqueue(getPostWorkRequest)
        return workManager.getWorkInfoByIdLiveData(getPostWorkRequest.id).asFlow()
    }
}