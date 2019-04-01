package com.jiujiu.mvvmTemplate.data.repository

import androidx.lifecycle.LiveData
import com.jiujiu.mvvmTemplate.data.local.dao.ProductDao
import com.jiujiu.mvvmTemplate.data.model.Product
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(private val productDao: ProductDao) : AnkoLogger {

    fun insert(vararg productList: Product) {
        productDao.insert(*productList)
        info( "insert products: " + productList.size + " item(s)")
    }

    fun loadAllProducts(): LiveData<List<Product>> {
        return productDao.loadAllProducts()
    }

    fun loadProductById(id: Long?): LiveData<Product> {
        return productDao.getProductById(id!!)
    }

}
