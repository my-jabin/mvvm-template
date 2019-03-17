package com.jiujiu.mvvmTemplate.di.component;

import android.app.Application;

import com.jiujiu.mvvmTemplate.MvvmApp;
import com.jiujiu.mvvmTemplate.di.builder.ActivityBuilder;
import com.jiujiu.mvvmTemplate.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * AndroidInjectionModule.class: provided by Dagger 2.10.
 * Contains bindings to ensure the usability of dagger.android framework classes.
 * <p>
 * AndroidSupportInjectionModule.class for supporting androidx
 * This module should be installed in the component that is used to inject the Application class.
 * <p>
 * ActivityBuilder.class: customized module. We map all activities here, tell Dagger all of our activities in compile time
 * <p>
 * AppModule.class: provides global dependencies. Like retrofit, okhttp, persitence db etc.
 */

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(MvvmApp app);

}
