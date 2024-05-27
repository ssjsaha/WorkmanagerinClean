package com.example.workmanagerinclean.data.remote

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.WorkerParameters
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

@HiltWorker
class GetPostWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted params: WorkerParameters,
    private val api: Api
) :
    CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        delay(2000)
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getPosts()
                if (response.isSuccessful) {

                    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                    val jsonAdapter = moshi.adapter(List::class.java).lenient()
                    val jsonString = jsonAdapter.toJson(response.body()?.take(10))
                    val data = Data
                        .Builder()
                        .putString("responseString", jsonString)
                        .build()
                    Result.success(data)
                } else {
                    Result.failure(
                        Data.Builder().putString("failure", response.errorBody()?.string()).build()
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Result.failure(Data.Builder().putString("failure", e.message).build())
            }
        }
    }
}