package com.jiujiu.mvvmprojecttutorial.di.component;

import android.app.Application;

import com.jiujiu.mvvmprojecttutorial.MvvmApp;
import com.jiujiu.mvvmprojecttutorial.di.builder.ActivityBuilder;
import com.jiujiu.mvvmprojecttutorial.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules ={ AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class})
public interface AppComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(MvvmApp app);

}
