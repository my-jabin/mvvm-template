package com.jiujiu.mvvmTemplate.ui.main;

import com.jiujiu.mvvmTemplate.data.DataManager;
import com.jiujiu.mvvmTemplate.ui.base.BaseViewModel;

import javax.inject.Inject;

public class MainFragViewModel extends BaseViewModel {

    @Inject
    public MainFragViewModel(DataManager dataManager) {
        super(dataManager);
    }

}
