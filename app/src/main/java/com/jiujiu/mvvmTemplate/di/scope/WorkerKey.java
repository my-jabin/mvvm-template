package com.jiujiu.mvvmTemplate.di.scope;

import androidx.work.ListenableWorker;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import dagger.MapKey;

@Retention(RetentionPolicy.RUNTIME)
@MapKey
public @interface WorkerKey {
    Class<? extends ListenableWorker> value();
}
