package com.cg.service;

import com.cg.model.EGender;
import com.cg.model.Product;
import com.cg.model.User;
import com.cg.utils.DateUtils;
import com.cg.utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private String fileProduct = "./data/products.txt";
    @Override
    public List<Product> getAllProducts() {
        return FileUtils.readData(fileProduct, Product.class);
    }

    @Override
    public Product findProduct(long id) {
        return null;
    }

    @Override
    public void updateProduct(long id, Product product) {

    }

    @Override
    public void deleteProduct(long id) {

    }

    @Override
    public void createProduct(Product product) {
        List<Product> products = getAllProducts();
        products.add(product);

        FileUtils.writeData(fileProduct, products);
    }
}
