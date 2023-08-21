package demo_socket_notify.controller;


import demo_socket_notify.Server;

import java.io.IOException;

public abstract class Controller {
    protected Request request;
    protected Response response;

    protected Server context;


    public abstract void doGet(Request request, Response response) throws IOException;
    public abstract void doPost(Request request, Response response) throws IOException;

    public abstract void init(Server context, Request request, Response response);

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
