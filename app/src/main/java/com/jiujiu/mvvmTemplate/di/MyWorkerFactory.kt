package com.jiujiu.mvvmTemplate.di

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters

import com.jiujiu.mvvmTemplate.worker.CustomWorkerFactory

import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class MyWorkerFactory @Inject
constructor(private val workerFactories: MutableMap<Class<out ListenableWorker>, Provider<CustomWorkerFactory>>) : WorkerFactory() {

    override fun createWorker(appContext: Context, workerClassName: String, workerParameters: WorkerParameters): ListenableWorker? {
        var listenableWorker: ListenableWorker? = null
        try {
            var provider: Provider<out CustomWorkerFactory>? = null
            for ((key, value) in workerFactories) {
                if (Class.forName(workerClassName).isAssignableFrom(key)) {
                    provider = value
                    break
                }
            }
            if (provider == null) {
                throw IllegalArgumentException("unknown model class $workerClassName")
            }
            listenableWorker = provider.get().create(appContext, workerParameters)
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }

        return listenableWorker
    }
}
