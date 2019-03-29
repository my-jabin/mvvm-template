package com.jiujiu.mvvmTemplate.worker

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.Worker
import androidx.work.WorkerParameters

import com.jiujiu.mvvmTemplate.data.DataManager
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class PrePopulateDataWorker @AssistedInject constructor(
        @Assisted context: Context,
        @Assisted workerParams: WorkerParameters,
        private val dataManager: DataManager
) : Worker(context, workerParams) {

    override fun doWork(): ListenableWorker.Result {
        dataManager.prePopulateData()
        return ListenableWorker.Result.success()
    }

    @AssistedInject.Factory
    interface Factory : CustomWorkerFactory
}
