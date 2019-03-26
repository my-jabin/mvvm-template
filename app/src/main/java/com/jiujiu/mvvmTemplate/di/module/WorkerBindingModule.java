package com.jiujiu.mvvmTemplate.di.module;

import androidx.work.WorkerFactory;

import com.jiujiu.mvvmTemplate.di.MyWorkerFactory;
import com.jiujiu.mvvmTemplate.di.scope.WorkerKey;
import com.jiujiu.mvvmTemplate.worker.CustomWorkerFactory;
import com.jiujiu.mvvmTemplate.worker.PrePopulateDataWorker;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class WorkerBindingModule {

    @Binds
    @IntoMap
    @WorkerKey(PrePopulateDataWorker.class)
    abstract CustomWorkerFactory bindsPrePopulateDataWorker(PrePopulateDataWorker.Factory factory);

    @Binds
    abstract WorkerFactory bindsWorkerFactory(MyWorkerFactory factory);
}
