package com.jiujiu.mvvmTemplate;

import android.app.Activity;
import android.app.Application;

import androidx.fragment.app.Fragment;
import androidx.work.Configuration;
import androidx.work.WorkManager;
import androidx.work.WorkerFactory;

import com.jiujiu.mvvmTemplate.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MvvmApp extends Application implements HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Inject
    DispatchingAndroidInjector<Fragment> supportFragmentInjector;

    @Inject
    WorkerFactory myWorkerFactory;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);

        WorkManager.initialize(this, new Configuration.Builder().setWorkerFactory(myWorkerFactory).build());


    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<androidx.fragment.app.Fragment> supportFragmentInjector() {
        return supportFragmentInjector;
    }
}
