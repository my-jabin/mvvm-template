package com.jiujiu.mvvmTemplate.ui.products

import androidx.lifecycle.LiveData
import com.jiujiu.mvvmTemplate.data.DataManager
import com.jiujiu.mvvmTemplate.data.model.Product
import com.jiujiu.mvvmTemplate.ui.base.BaseViewModel
import javax.inject.Inject

class ProductsFragViewModel @Inject constructor(
        dataManager: DataManager
) : BaseViewModel(dataManager) {

    val productLiveData: LiveData<List<Product>> by lazy {
        dataManager.allProducts
    }

}
