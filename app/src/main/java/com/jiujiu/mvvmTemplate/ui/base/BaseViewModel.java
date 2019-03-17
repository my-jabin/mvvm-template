package com.jiujiu.mvvmTemplate.ui.base;

import com.jiujiu.mvvmTemplate.data.DataManager;

import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;

// todo: remove generic type N, mNatigator
public class BaseViewModel extends ViewModel {

    private CompositeDisposable mDisposable;
    private final DataManager mDataManager;

    public BaseViewModel(DataManager dataManager) {
        mDisposable = new CompositeDisposable();
        this.mDataManager = dataManager;
    }

    public DataManager getDataManager() {
        return mDataManager;
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
