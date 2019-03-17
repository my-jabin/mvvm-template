package com.jiujiu.mvvmTemplate.ui.main.fragments;

import com.jiujiu.mvvmTemplate.data.DataManager;
import com.jiujiu.mvvmTemplate.ui.base.BaseViewModel;

import javax.inject.Inject;

public class ProductsFragViewModel extends BaseViewModel {
    @Inject
    public ProductsFragViewModel(DataManager dataManager) {
        super(dataManager);
    }


}
