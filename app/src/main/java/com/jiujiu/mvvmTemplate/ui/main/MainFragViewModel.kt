package com.jiujiu.mvvmTemplate.ui.main

import com.jiujiu.mvvmTemplate.data.DataManager
import com.jiujiu.mvvmTemplate.ui.base.BaseViewModel

import javax.inject.Inject

class MainFragViewModel @Inject constructor(
        dataManager: DataManager
) : BaseViewModel(dataManager)
