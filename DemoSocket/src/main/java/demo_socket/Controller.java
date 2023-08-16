package demo_socket;


import java.io.IOException;

public abstract class Controller {
    protected Request request;
    protected Response response;


    public abstract void doGet(Request request, Response response) throws IOException;
    public abstract void doPost(Request request, Response response) throws IOException;
}
