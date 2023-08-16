package demo_socket_manager;




import demo_socket_manager.controller.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public Server(){
        ServerSocket listener = null;
        System.out.println("Server is waiting to accept user...");
        int clientNumber = 0;
        try {
            listener = new ServerSocket(9999);
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }

        try {
            while (true) {
                Socket socketOfServer = listener.accept();
                new ServiceThread(socketOfServer, clientNumber++).start();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                listener.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static class ServiceThread extends Thread {
        private Scanner scanner = new Scanner(System.in);

        private int clientNumber;
        private Socket socketOfServer;

        public ServiceThread(Socket socketOfServer, int clientNumber) {
            this.clientNumber = clientNumber;
            this.socketOfServer = socketOfServer;
        }

        @Override
        public void run() {
            try {
                // Mở luồng vào ra trên Socket tại Server.
                ObjectInputStream is = new ObjectInputStream(socketOfServer.getInputStream());
                ObjectOutputStream os = new ObjectOutputStream(socketOfServer.getOutputStream());

                boolean check = true;
                while (check) {
                    Object objReq = is.readObject();

                    Controller controller  = null;
                    if (objReq != null) {
                        Request request = (Request) objReq;
                        Response response = new Response();
                        response.setObjectOutputStream(os);

                        if (request.getController().contains("/product")) {
                            controller = ProductController.getInstance();
                        }
                        if (request.getController().contains("/student")) {
                            controller = StudentController.getInstance();
                        }

                        controller.init();
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
    }


    public static void main(String[] args) {
        Server server = new Server();

    }
}
