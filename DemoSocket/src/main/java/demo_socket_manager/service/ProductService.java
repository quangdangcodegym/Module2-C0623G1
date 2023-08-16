package demo_socket_manager.service;

import demo_socket_manager.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products;
    private ProductService() {
        products = new ArrayList<>();
        products.add(new Product(1L, "IPHONE 11"));
        products.add(new Product(2L, "IPHONE 12"));
    }

    private  static ProductService INSTANCE_PRODUCT_SERVICE ;
    public static ProductService getInstance() {
        if (INSTANCE_PRODUCT_SERVICE == null) {
            INSTANCE_PRODUCT_SERVICE = new ProductService();
        }
        return INSTANCE_PRODUCT_SERVICE;
    }
    public List<Product> getProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        product.setId(getProducts().size());
        products.add(product);

        return products.get(products.size() - 1);
    }


}
