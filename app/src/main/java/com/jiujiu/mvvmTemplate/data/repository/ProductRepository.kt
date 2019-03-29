package com.jiujiu.mvvmTemplate.data.repository

import android.util.Log
import com.jiujiu.mvvmTemplate.data.local.dao.ProductDao
import com.jiujiu.mvvmTemplate.data.model.Product
import io.reactivex.Maybe
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(private val productDao: ProductDao) {

    fun insert(vararg productList: Product) {
        productDao.insert(*productList)
        Log.d(TAG, "insert products: " + productList.size + " item(s)")
    }


    fun loadAllProducts(): Observable<List<Product>> {
        return productDao.loadAllProducts()
    }

    fun loadProductById(id: Long): Maybe<Product> {
        return productDao.getProductById(id)
    }

    companion object {
        private val TAG by lazy { ProductRepository::class.simpleName }
    }
}
