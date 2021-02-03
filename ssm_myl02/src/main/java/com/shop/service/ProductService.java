package com.shop.service;

import com.shop.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProductList();

    Product getProductById(String id);

    void updateitem(Product product);
}
