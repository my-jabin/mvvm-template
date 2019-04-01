package com.jiujiu.mvvmTemplate.ui.base

import androidx.lifecycle.ViewModel

import com.jiujiu.mvvmTemplate.data.DataManager

import org.jetbrains.anko.AnkoLogger

open class BaseViewModel(protected val dataManager: DataManager) : ViewModel(), AnkoLogger