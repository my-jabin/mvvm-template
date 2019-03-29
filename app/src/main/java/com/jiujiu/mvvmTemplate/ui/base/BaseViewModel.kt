package com.jiujiu.mvvmTemplate.ui.base

import androidx.lifecycle.ViewModel

import com.jiujiu.mvvmTemplate.data.DataManager

import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel(protected val dataManager: DataManager) : ViewModel() {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
