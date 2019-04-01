package com.jiujiu.mvvmTemplate.di.builder

import com.jiujiu.mvvmTemplate.di.module.MainActivityModule
import com.jiujiu.mvvmTemplate.ui.main.MainActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindsMainActivity(): MainActivity

}
