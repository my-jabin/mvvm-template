package com.jiujiu.mvvmTemplate.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jiujiu.mvvmTemplate.data.DataManager
import com.jiujiu.mvvmTemplate.ui.base.BaseViewModel
import com.jiujiu.mvvmTemplate.util.Event

import javax.inject.Inject

class MainFragViewModel @Inject constructor(
        dataManager: DataManager
) : BaseViewModel(dataManager) {


    private val _bottomeNaviClickEvent = MutableLiveData<Event<Int>>()
    val onBottomNaviClickEvent: LiveData<Event<Int>>
        get() = _bottomeNaviClickEvent

    fun clickBottomNavigation(id: Int) {
        _bottomeNaviClickEvent.value = Event(id)
    }
}
