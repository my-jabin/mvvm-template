package com.jiujiu.mvvmTemplate.data.repository;

import android.util.Log;

import com.jiujiu.mvvmTemplate.data.local.dao.ProductDao;
import com.jiujiu.mvvmTemplate.data.model.Product;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Maybe;
import io.reactivex.Observable;

@Singleton
public class ProductRepository {

    private static final String TAG = "ProductRepository";

    private ProductDao productDao;

    @Inject
    public ProductRepository(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void insert(Product... productList) {
        productDao.insert(productList);
        Log.d(TAG, "insert products: " + productList.length + " item(s)");
    }


    public Observable<List<Product>> loadAllProducts() {
        return productDao.loadAllProducts();
    }

    public Maybe<Product> loadProductById(Long id) {
        return productDao.getProductById(id);
    }
}
