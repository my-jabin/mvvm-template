package com.jiujiu.mvvmTemplate.ui.base;

import android.arch.lifecycle.ViewModel;

import com.jiujiu.mvvmTemplate.data.DataManager;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel<N> extends ViewModel {

    private CompositeDisposable mDisposable;
    private N mNavigator;
    private final DataManager mDataManager;

    public BaseViewModel(DataManager dataManager) {
        mDisposable = new CompositeDisposable();
        this.mDataManager = dataManager;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public void setNavigator(N navigator) {
        this.mNavigator = navigator;
    }

    public N getNavigator() {
        return this.mNavigator;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mDisposable;
    }

    @Override
    protected void onCleared() {
        mDisposable.dispose();
        super.onCleared();
    }
}
