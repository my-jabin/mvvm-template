package com.jiujiu.mvvmTemplate.ui.products.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.jiujiu.mvvmTemplate.data.DataManager
import com.jiujiu.mvvmTemplate.data.model.Product
import com.jiujiu.mvvmTemplate.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductDetailViewModel @Inject constructor(
        dataManager: DataManager
) : BaseViewModel(dataManager) {

    private var mProductLiveData: MediatorLiveData<Product> = MediatorLiveData()

    val productLiveData: LiveData<Product>
        get() = mProductLiveData

    fun loadProductById(productId: Long?) {
        viewModelScope.launch {
            mProductLiveData.addSource(dataManager.getProductById(productId)) { mProductLiveData.postValue(it) }
        }
    }

}
