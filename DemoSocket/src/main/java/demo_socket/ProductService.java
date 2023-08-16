package demo_socket;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products;
    public ProductService() {
        products = new ArrayList<>();
        products.add(new Product(1L, "IPHONE 11"));
        products.add(new Product(2L, "IPHONE 12"));
    }

    public List<Product> getProducts() {
        return products;
    }


}
