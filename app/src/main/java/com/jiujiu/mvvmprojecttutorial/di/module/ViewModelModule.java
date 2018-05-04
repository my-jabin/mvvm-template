package com.jiujiu.mvvmprojecttutorial.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.jiujiu.mvvmprojecttutorial.di.ViewModelFactory;
import com.jiujiu.mvvmprojecttutorial.di.ViewModelKey;
import com.jiujiu.mvvmprojecttutorial.ui.main.MainActivityViewModel;
import com.jiujiu.mvvmprojecttutorial.ui.splash.SplashActivityViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashActivityViewModel.class)
    abstract ViewModel bindsSplashActivityViewModel(SplashActivityViewModel splashActivityViewModel);


    @Binds
    @IntoMap
    @ViewModelKey(SplashActivityViewModel.class)
    abstract ViewModel bindsMainActivityViewModel(MainActivityViewModel mainActivityViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory factory);
}
