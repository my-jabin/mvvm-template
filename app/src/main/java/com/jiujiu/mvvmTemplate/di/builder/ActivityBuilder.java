package com.jiujiu.mvvmTemplate.di.builder;

import com.jiujiu.mvvmTemplate.ui.main.MainActivity;
import com.jiujiu.mvvmTemplate.ui.settings.SettingsActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    // @ContributesAndroidInjector(modules = SplashActivityModule.class)
    // SplashActivityModule provides the dependencies specific to the SettingsActivity
    @ContributesAndroidInjector()
    abstract SettingsActivity bindsSettingsActivity();

    @ContributesAndroidInjector()
    abstract MainActivity bindsMainActivity();

}
