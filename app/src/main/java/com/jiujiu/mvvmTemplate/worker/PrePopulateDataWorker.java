package com.jiujiu.mvvmTemplate.worker;

import android.content.Context;

import com.jiujiu.mvvmTemplate.data.DataManager;
import com.squareup.inject.assisted.Assisted;
import com.squareup.inject.assisted.AssistedInject;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class PrePopulateDataWorker extends Worker {
    private static final String TAG = "PrePopulateDataWorker";

    private DataManager dataManager;

    @AssistedInject
    public PrePopulateDataWorker(@Assisted @NonNull Context context, @Assisted @NonNull WorkerParameters workerParams, DataManager dataManager) {
        super(context, workerParams);
        this.dataManager = dataManager;
    }

    @NonNull
    @Override
    public Result doWork() {
        dataManager.prePupulateData();
        return Result.success();
    }

    @AssistedInject.Factory
    public interface Factory extends CustomWorkerFactory {
    }
}
