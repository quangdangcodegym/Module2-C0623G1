package demo_socket;

import java.io.IOException;

public class ProductController extends Controller{

    private ProductService productService;

    public ProductController(Request request, Response response){
        productService = new ProductService();
        this.request = request;
        this.response =response;
    }
    @Override
    public void doGet(Request request, Response response) throws IOException {
        if(request.getAction().equals("show")){
            response.setStatusCode("OK");
            response.setData(productService.getProducts());
            response.getObjectOutputStream().writeObject(response);
        }
    }

    @Override
    public void doPost(Request request, Response response) throws IOException{

    }
}
