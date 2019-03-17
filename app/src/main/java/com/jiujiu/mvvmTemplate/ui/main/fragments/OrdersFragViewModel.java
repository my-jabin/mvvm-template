package com.jiujiu.mvvmTemplate.ui.main.fragments;

import com.jiujiu.mvvmTemplate.data.DataManager;
import com.jiujiu.mvvmTemplate.ui.base.BaseViewModel;

import javax.inject.Inject;

public class OrdersFragViewModel extends BaseViewModel {
    @Inject
    public OrdersFragViewModel(DataManager dataManager) {
        super(dataManager);
    }


}
