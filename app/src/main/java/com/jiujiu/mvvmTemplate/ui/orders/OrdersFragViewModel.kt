package com.jiujiu.mvvmTemplate.ui.orders

import com.jiujiu.mvvmTemplate.data.DataManager
import com.jiujiu.mvvmTemplate.ui.base.BaseViewModel

import javax.inject.Inject

class OrdersFragViewModel @Inject constructor(
        dataManager: DataManager
) : BaseViewModel(dataManager)
