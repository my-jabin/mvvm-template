package com.jiujiu.mvvmTemplate.data;

import com.jiujiu.mvvmTemplate.data.model.Product;
import com.jiujiu.mvvmTemplate.data.repository.ProductRepository;
import com.jiujiu.mvvmTemplate.util.AppConstant;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Maybe;
import io.reactivex.Observable;

@Singleton
public class DataManager {

    private AppPreference mPreference;
    private ProductRepository mProductRepository;

    @Inject
    public DataManager(AppPreference preference, ProductRepository productRepository) {
        mPreference = preference;
        this.mProductRepository = productRepository;
        setCurrentUserName(AppConstant.USERNAME);
    }

    public String getCurrentUserName() {
        return this.mPreference.getUserName();
    }

    public void setCurrentUserName(String userName) {
        this.mPreference.setUserName(userName);
    }

    public void prePupulateData() {
        List<Product> products = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Product p = new Product();
            p.name = "Product Name " + i;
            p.price = i * 10;
            p.brand = "Brand " + i;
            products.add(p);
        }
        mProductRepository.insert(products.toArray(new Product[products.size()]));
    }

    public Observable<List<Product>> getAllProducts() {
        return this.mProductRepository.loadAllProducts();
    }

    public Maybe<Product> getProductById(Long id) {
        return this.mProductRepository.loadProductById(id);
    }
}
