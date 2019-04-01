package com.jiujiu.mvvmTemplate.di.component

import com.jiujiu.mvvmTemplate.MvvmApp
import com.jiujiu.mvvmTemplate.di.builder.ActivityBuilder
import com.jiujiu.mvvmTemplate.di.module.AppModule
import com.jiujiu.mvvmTemplate.di.module.WorkerAssistedInjectModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * AndroidInjectionModule.class: provided by Dagger 2.10.
 * Contains bindings to ensure the usability of dagger.android framework classes.
 *
 *
 * AndroidSupportInjectionModule.class for supporting androidx
 * This module should be installed in the component that is used to inject the Application class.
 *
 *
 * ActivityBuilder.class: customized module. We map all activities here, tell Dagger all of our activities in compile time
 *
 *
 * AppModule.class: provides global dependencies. Like retrofit, okhttp, persitence db etc.
 */

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    WorkerAssistedInjectModule::class,
    AppModule::class,
    ActivityBuilder::class])
interface AppComponent : AndroidInjector<MvvmApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MvvmApp>()

}
