package com.jiujiu.mvvmTemplate.worker;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.jiujiu.mvvmTemplate.data.DataManager;
import com.squareup.inject.assisted.Assisted;
import com.squareup.inject.assisted.AssistedInject;

public class PrePopulateDataWorker extends Worker {
    private static final String TAG = "PrePopulateDataWorker";

    private DataManager dataManager;

    public PrePopulateDataWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

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
