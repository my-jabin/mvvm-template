package com.jiujiu.mvvmprojecttutorial.ui.base;

import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel<N> extends ViewModel {

    private CompositeDisposable disposable;
    private N mNavigator;


    public BaseViewModel() {
        disposable = new CompositeDisposable();
    }


    public void setNavigator(N navigator){
        this.mNavigator = navigator;
    }

    public N getNavigator(){
        return this.mNavigator;
    }

    public CompositeDisposable getCompositeDisposable() {
        return disposable;
    }

    @Override
    protected void onCleared() {
        disposable.dispose();
        super.onCleared();
    }
}
