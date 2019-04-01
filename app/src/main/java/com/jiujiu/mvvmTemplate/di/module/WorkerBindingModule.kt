package com.jiujiu.mvvmTemplate.di.module

import androidx.work.WorkerFactory

import com.jiujiu.mvvmTemplate.di.MyWorkerFactory
import com.jiujiu.mvvmTemplate.di.scope.WorkerKey
import com.jiujiu.mvvmTemplate.worker.CustomWorkerFactory
import com.jiujiu.mvvmTemplate.worker.PrePopulateDataWorker

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class WorkerBindingModule {

    @Binds
    @IntoMap
    @WorkerKey(PrePopulateDataWorker::class)
    abstract fun bindsPrePopulateDataWorker(factory: PrePopulateDataWorker.Factory): CustomWorkerFactory

    @Binds
    abstract fun bindsWorkerFactory(factory: MyWorkerFactory): WorkerFactory
}
