package com.jiujiu.mvvmTemplate.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.lifecycle.ViewModel;
import dagger.MapKey;

@Retention(RetentionPolicy.RUNTIME)
@MapKey
public @interface ViewModelKey {
    Class<? extends ViewModel> value();
}
