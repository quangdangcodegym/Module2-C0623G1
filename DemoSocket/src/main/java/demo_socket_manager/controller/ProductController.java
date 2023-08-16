package demo_socket_manager.controller;

import demo_socket_manager.service.ProductService;
import demo_socket_manager.model.Product;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class ProductController extends Controller {

    private ProductService productService;


    @Override
    public void init(){
        productService = ProductService.getInstance();
    }

    private ProductController() {

    }
    private static ProductController INSTANCE_PRODUCT_CONTROLLER ;
    public static ProductController getInstance() {
        if (INSTANCE_PRODUCT_CONTROLLER == null) {
            INSTANCE_PRODUCT_CONTROLLER = new ProductController();
        }
        return INSTANCE_PRODUCT_CONTROLLER;
    }
    @Override
    public void doGet(Request request, Response response) throws IOException {
        if(request.getAction().equals("show")){
            DecimalFormat decimalFormat = new DecimalFormat("0.00");

            // Sử dụng đối tượng DecimalFormat để làm tròn số
            String roundedNumber = decimalFormat.format(10 + Math.random());
            response.setStatusCode("OK" + roundedNumber);
            response.setData(productService.getProducts());

            System.out.println("SERVER: gửi về thông tin " + productService.getProducts());

            List<Product> temps = List.copyOf(productService.getProducts());

            response.setData(temps);
            response.getObjectOutputStream().writeObject(response);
            response.getObjectOutputStream().flush();
        }
    }

    @Override
    public void doPost(Request request, Response response) throws IOException{
        if (request.getAction().equals("create")) {
            response.setStatusCode("OK");

            Product p = (Product) request.getData();
            // p chưa có Id => sau khi trả ra p sẽ có ID;
            p = productService.addProduct(p);

            response.getObjectOutputStream().writeObject(response);
            response.getObjectOutputStream().flush();
        }
    }
}
