package com.jiujiu.mvvmTemplate.ui.customers

import androidx.lifecycle.MutableLiveData

import com.jiujiu.mvvmTemplate.data.DataManager
import com.jiujiu.mvvmTemplate.ui.base.BaseViewModel

import javax.inject.Inject

class CustomersFragViewModel @Inject constructor(
        dataManager: DataManager
) : BaseViewModel(dataManager) {

    var customerName = MutableLiveData<String>()

    init {
        customerName.value = dataManager.currentUserName
    }

}
