package com.jiujiu.mvvmTemplate.di.builder;

import com.jiujiu.mvvmTemplate.di.module.main.MainActivityModule;
import com.jiujiu.mvvmTemplate.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindsMainActivity();

}
