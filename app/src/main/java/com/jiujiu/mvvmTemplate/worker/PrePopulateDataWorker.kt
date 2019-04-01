package com.jiujiu.mvvmTemplate.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

import com.jiujiu.mvvmTemplate.data.DataManager
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope

class PrePopulateDataWorker @AssistedInject constructor(
        @Assisted context: Context,
        @Assisted workerParams: WorkerParameters,
        private val dataManager: DataManager
) : CoroutineWorker(context, workerParams) {

    override val coroutineContext = Dispatchers.IO

    override suspend fun doWork(): Result {
        return coroutineScope {
            dataManager.prePopulateData()
            Result.success()
        }
    }

    @AssistedInject.Factory
    interface Factory : CustomWorkerFactory
}
