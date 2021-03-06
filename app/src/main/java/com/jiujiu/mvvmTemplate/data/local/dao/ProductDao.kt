package com.jiujiu.mvvmTemplate.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jiujiu.mvvmTemplate.data.model.Product

@Dao
interface ProductDao {

    @Query("select * from Product where id = :id")
    fun getProductById(id: Long): LiveData<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg products: Product)

    @Delete
    fun delete(product: Product)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(product: Product)

    @Query("SELECT * FROM product")
    fun loadAllProducts(): LiveData<List<Product>>
}
