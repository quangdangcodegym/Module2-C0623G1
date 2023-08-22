package com.cg.service;


import com.cg.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product findProduct(long id);

    void updateProduct(long id, Product product);

    void deleteProduct(long id);

    void createProduct(Product product);
}
