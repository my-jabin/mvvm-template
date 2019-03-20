package com.jiujiu.mvvmTemplate.worker;

import android.content.Context;

import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;

public interface CustomWorkerFactory {
    ListenableWorker create(Context context, WorkerParameters workerParams);
}
