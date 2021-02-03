package com.shop.service.impl;

import com.shop.dao.ProductMapper;
import com.shop.domain.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getProductList() {


       // List<Product> products = this.productMapper.selectByExample(null);
        List<Product> products = this.productMapper.selectByExampleWithBLOBs(null);
        return products;
    }

    @Override
    public Product getProductById(String id) {
        return this.productMapper.selectByPrimaryKey(Integer.parseInt(id));
    }

    @Override
    public void updateitem(Product product) {
        //this.productMapper.updateByPrimaryKey(product);
        this.productMapper.updateByPrimaryKeySelective(product);
    }
}
