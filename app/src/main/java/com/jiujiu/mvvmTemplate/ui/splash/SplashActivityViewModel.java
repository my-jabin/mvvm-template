package com.jiujiu.mvvmTemplate.ui.splash;

import com.jiujiu.mvvmTemplate.data.DataManager;
import com.jiujiu.mvvmTemplate.ui.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SplashActivityViewModel extends BaseViewModel<SplashNavigator> {

    @Inject
    public SplashActivityViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public void startSeeding() {
        getCompositeDisposable().add(
                Completable.fromRunnable(() -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                () -> getNavigator().openMainActivity())
        );
    }

    public void setCurrentUserName(String userName) {
        getDataManager().setCurrentUserName(userName);
    }
}
