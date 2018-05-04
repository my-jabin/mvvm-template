package com.jiujiu.mvvmprojecttutorial.di.builder;

import com.jiujiu.mvvmprojecttutorial.ui.main.MainActivity;
import com.jiujiu.mvvmprojecttutorial.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

//    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    @ContributesAndroidInjector()
    abstract SplashActivity bindsSplashActivity();

    @ContributesAndroidInjector()
    abstract MainActivity bindsMainActivity();

}