package com.jiujiu.mvvmTemplate.data

import com.jiujiu.mvvmTemplate.data.model.Product
import com.jiujiu.mvvmTemplate.data.repository.ProductRepository
import com.jiujiu.mvvmTemplate.util.AppConstant
import io.reactivex.Maybe
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(
        private val mPreference: AppPreference,
        private val mProductRepository: ProductRepository
) {

    var currentUserName: String?
        get() = this.mPreference.userName
        set(userName) {
            this.mPreference.userName = userName
        }

    val allProducts: Observable<List<Product>>
        get() = this.mProductRepository.loadAllProducts()

    init {
        currentUserName = AppConstant.USERNAME
    }

    fun prePopulateData() {
        val products = arrayListOf<Product>().apply {
            for (i in 1..5) {
                add(Product(null, "product Name $i", "Brand $i", i * 10.0))
            }
        }
        mProductRepository.insert(*products.toTypedArray())
    }

    fun getProductById(id: Long?): Maybe<Product> {
        return this.mProductRepository.loadProductById(id)
    }
}
