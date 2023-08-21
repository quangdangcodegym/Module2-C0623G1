package demo_socket_notify;

import demo_socket_notify.controller.*;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServiceThread extends Thread {


    private Server context;
    private Scanner scanner = new Scanner(System.in);

    private String clientId;
    private Socket socketOfServer;
    private ObjectInputStream is ;
    private ObjectOutputStream os;
    Controller controller;

    public ServiceThread(Socket socketOfServer, String clientId, Server  context) {
        this.clientId = clientId;
        this.socketOfServer = socketOfServer;
        this.context = context;
    }

    @Override
    public void run() {
        try {
            // Mở luồng vào ra trên Socket tại Server.
            is = new ObjectInputStream(socketOfServer.getInputStream());
            os = new ObjectOutputStream(socketOfServer.getOutputStream());


            boolean check = true;
            while (check) {
                Object objReq = is.readObject();
                if (objReq != null) {
                    Request request = (Request) objReq;
                    Response response = new Response();


                    response.setObjectOutputStream(os);

                    System.out.printf("Request: method: %s action: %s url: %s \n", request.getMethod(), request.getAction(), request.getController());
                    if (request.getController().contains("/product")) {
                        controller = ProductController.getInstance();
                    }
                    if (request.getController().contains("/student")) {
                        controller = StudentController.getInstance();
                    }
                    if (request.getController().contains("/notify")) {
                        controller = NotifyController.getInstance();
                    }

                    controller.init(context, request, response);
                    switch (request.getMethod()) {
                        case "GET" -> {
                            controller.doGet(request, response);
                        }
                        case "POST" -> {
                            controller.doPost(request, response);
                        }
                    }
                }
            }
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }

    public Server getContext() {
        return context;
    }

    public void setContext(Server context) {
        this.context = context;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public ObjectInputStream getIs() {
        return is;
    }

    public void setIs(ObjectInputStream is) {
        this.is = is;
    }

    public ObjectOutputStream getOs() {
        return os;
    }

    public void setOs(ObjectOutputStream os) {
        this.os = os;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void sendMessage(String message) {
        try {
            //public Response(String method, String statusCode, String action, String controller, Object data) {
            Response response = new Response(null, "OK", "notify", "/notify", message);
            os.writeObject(response);
            os.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
