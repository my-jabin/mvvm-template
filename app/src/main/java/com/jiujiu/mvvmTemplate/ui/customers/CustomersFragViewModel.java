package com.jiujiu.mvvmTemplate.ui.customers;

import androidx.lifecycle.MutableLiveData;

import com.jiujiu.mvvmTemplate.data.DataManager;
import com.jiujiu.mvvmTemplate.ui.base.BaseViewModel;

import javax.inject.Inject;

public class CustomersFragViewModel extends BaseViewModel {

    public MutableLiveData<String> customerName = new MutableLiveData<>();

    @Inject
    public CustomersFragViewModel(DataManager dataManager) {
        super(dataManager);
        customerName.setValue(dataManager.getCurrentUserName());
    }

}
