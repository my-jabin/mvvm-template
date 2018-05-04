package com.jiujiu.mvvmprojecttutorial.ui.splash;

import android.arch.lifecycle.ViewModel;

import com.jiujiu.mvvmprojecttutorial.ui.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.Schedulers;

public class SplashActivityViewModel extends BaseViewModel<SplashNavigator> {

    @Inject
    public SplashActivityViewModel() {
        super();
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
}
