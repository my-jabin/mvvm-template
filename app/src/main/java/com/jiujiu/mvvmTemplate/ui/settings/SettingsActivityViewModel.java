package com.jiujiu.mvvmTemplate.ui.settings;

import com.jiujiu.mvvmTemplate.data.DataManager;
import com.jiujiu.mvvmTemplate.ui.base.BaseViewModel;

import javax.inject.Inject;

public class SettingsActivityViewModel extends BaseViewModel {

    @Inject
    public SettingsActivityViewModel(DataManager dataManager) {
        super(dataManager);
    }

//    public void startSeeding() {
//        getCompositeDisposable().add(
//                Completable.fromRunnable(() -> {
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }).subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(
//                                () -> getNavigator().openMainActivity())
//        );
//    }

    public void setCurrentUserName(String userName) {
        getDataManager().setCurrentUserName(userName);
    }
}
