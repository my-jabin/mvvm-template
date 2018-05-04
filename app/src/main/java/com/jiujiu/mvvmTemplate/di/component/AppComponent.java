package com.jiujiu.mvvmTemplate.di.component;

import android.app.Application;

import com.jiujiu.mvvmTemplate.MvvmApp;
import com.jiujiu.mvvmTemplate.di.builder.ActivityBuilder;
import com.jiujiu.mvvmTemplate.di.module.AppModule;

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
