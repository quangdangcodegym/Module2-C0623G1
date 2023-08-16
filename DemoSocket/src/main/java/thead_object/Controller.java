package thead_object;

import java.io.IOException;

public abstract class Controller {

    protected Request request;
    protected Response response;
    public abstract String doGet(Request request, Response response) throws IOException;

    public abstract String doPost(Request request, Response response) throws IOException;


    public void setStatusCode(String statusCode){
        this.response.setStatusCode(statusCode);
    }

}
