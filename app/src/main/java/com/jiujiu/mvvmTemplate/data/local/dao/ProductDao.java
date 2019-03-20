package com.jiujiu.mvvmTemplate.data.local.dao;

import com.jiujiu.mvvmTemplate.data.model.Product;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import io.reactivex.Maybe;
import io.reactivex.Observable;


@Dao
public interface ProductDao {

    @Query("select * from Product where id = :id")
    Maybe<Product> getProductById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Product... product);

    @Delete
    void delete(Product product);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Product product);

    @Query("SELECT * FROM product")
    Observable<List<Product>> loadAllProducts();
}
