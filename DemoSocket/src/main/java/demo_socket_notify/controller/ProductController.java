package demo_socket_notify.controller;

import demo_socket_notify.Server;
import demo_socket_notify.model.Product;
import demo_socket_notify.service.ProductService;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class ProductController extends Controller {

    private ProductService productService;


    @Override
    public void init(Server context, Request request, Response response){
        productService = ProductService.getInstance();
        this.context = context;
        this.request = request;
        this.response = response;
        this.response.setController("/product");
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

            // Sử dụng đối tượng DecimalFormat để làm tròn số
            response.setStatusCode("OK");
            response.setData(productService.getProducts());
            response.setAction("show");


            System.out.println("SERVER: gửi về thông tin " + response);
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
            response.setAction("create");

            Product p = (Product) request.getData();
            // p chưa có Id => sau khi trả ra p sẽ có ID;
            p = productService.addProduct(p);

            response.getObjectOutputStream().writeObject(response);
            response.getObjectOutputStream().flush();
        }
    }
}
