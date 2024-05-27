package com.example.workmanagerinclean

import android.app.Application
import android.content.Context
import androidx.work.Configuration
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.example.workmanagerinclean.data.remote.Api
import com.example.workmanagerinclean.data.remote.GetPostWorker
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


@HiltAndroidApp
class WmApplication : Application(), androidx.work.Configuration.Provider {
    @Inject
    lateinit var workerFactory: CustomWorkerFactory

    override fun onCreate() {
        super.onCreate()
    }

    override fun getWorkManagerConfiguration() =
        Configuration.Builder().setWorkerFactory(workerFactory).build()
}

class CustomWorkerFactory @Inject constructor(private val api: Api) : WorkerFactory() {
    override fun createWorker(
        appContext: Context, workerClassName: String, workerParameters: WorkerParameters
    ): ListenableWorker = GetPostWorker(appContext, workerParameters, api)

}