package com.jiujiu.mvvmTemplate.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.jiujiu.mvvmTemplate.di.ViewModelFactory;
import com.jiujiu.mvvmTemplate.di.ViewModelKey;
import com.jiujiu.mvvmTemplate.ui.main.MainActivityViewModel;
import com.jiujiu.mvvmTemplate.ui.settings.SettingsActivityViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SettingsActivityViewModel.class)
    abstract ViewModel bindsSettingsActivityViewModel(SettingsActivityViewModel settingsActivityViewModel);


    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel.class)
    abstract ViewModel bindsMainActivityViewModel(MainActivityViewModel mainActivityViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory factory);
}
