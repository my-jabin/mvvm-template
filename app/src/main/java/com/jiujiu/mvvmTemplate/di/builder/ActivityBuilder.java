package com.jiujiu.mvvmTemplate.di.builder;

import com.jiujiu.mvvmTemplate.ui.main.MainActivity;
import com.jiujiu.mvvmTemplate.ui.splash.SplashActivity;

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
