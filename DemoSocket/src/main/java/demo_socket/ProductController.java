package demo_socket;

import java.io.IOException;

public class ProductController extends Controller{

    public ProductController(Request request, Response response){
        this.request = request;
        this.response =response;
    }
    @Override
    public void doGet(Request request, Response response) throws IOException {
        if(request.getAction().equals("show")){
            response.setStatusCode("OK");
            response.setData("DANH SÁCH PRODUCTS là....");
            response.getObjectOutputStream().writeObject(response);
        }
    }

    @Override
    public void doPost(Request request, Response response) throws IOException{

    }
}
