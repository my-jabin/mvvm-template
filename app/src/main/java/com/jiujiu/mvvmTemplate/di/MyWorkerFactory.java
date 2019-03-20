package com.jiujiu.mvvmTemplate.di;

import android.content.Context;

import com.jiujiu.mvvmTemplate.worker.CustomWorkerFactory;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.ListenableWorker;
import androidx.work.WorkerFactory;
import androidx.work.WorkerParameters;

@Singleton
public class MyWorkerFactory extends WorkerFactory {

    private final Map<Class<? extends ListenableWorker>, Provider<CustomWorkerFactory>> workerFactories;

    @Inject
    public MyWorkerFactory(Map<Class<? extends ListenableWorker>, Provider<CustomWorkerFactory>> workerFactories) {
        this.workerFactories = workerFactories;
    }

    @Nullable
    @Override
    public ListenableWorker createWorker(@NonNull Context appContext, @NonNull String workerClassName, @NonNull WorkerParameters workerParameters) {
        ListenableWorker listenableWorker = null;
        try {
            Provider<? extends CustomWorkerFactory> provider = null;
            for (Map.Entry<Class<? extends ListenableWorker>, Provider<CustomWorkerFactory>> entry : workerFactories.entrySet()) {
                if (Class.forName(workerClassName).isAssignableFrom(entry.getKey())) {
                    provider = entry.getValue();
                    break;
                }
            }
            if (provider == null) {
                throw new IllegalArgumentException("unknown model class " + workerClassName);
            }
            listenableWorker = provider.get().create(appContext, workerParameters);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listenableWorker;
    }
}
