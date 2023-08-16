package thead_object;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class DispatchServer {

    public static void main(String args[]) throws IOException {

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
        } finally {
            listener.close();
        }

    }

    private static void log(String message) {
        System.out.println(message);
    }

    private static class ServiceThread extends Thread {

        private int clientNumber;
        private Socket socketOfServer;

        public ServiceThread(Socket socketOfServer, int clientNumber) {
            this.clientNumber = clientNumber;
            this.socketOfServer = socketOfServer;
            log("New connection with client# " + this.clientNumber + " at " + socketOfServer);
        }

        @Override
        public void run() {
            System.out.println("CHAY THEAD NÀO");
            try {

                ObjectInputStream is = new ObjectInputStream(socketOfServer.getInputStream());
                ObjectOutputStream os = new ObjectOutputStream(socketOfServer.getOutputStream());

                Object objRequest = null;
                Controller controller = null;
                while (true) {
                    System.out.println("ĐỌC DỮ LIỆU");
                    if ((objRequest = is.readObject()) != null) {
                        Request request = (Request) objRequest;
                        Response  response = new Response();

                        request.setRequestId(String.valueOf(clientNumber));
                        response.setObjectOutputStream(os);
                        request.setObjectInputStream(is);

                        String strController = request.getController();
                        String strMethod = request.getMethod();
                        if (strController.contains("employee")) {
                            controller = new EmployeeController(request, response);
                        }

                        switch (strMethod) {
                            case "GET" -> {
                                controller.doGet(request, response);
                            }
                            case "POST" -> {
                                controller.doPost(request, response);
                            }
                        }

                    }
                }

            } catch (IOException e) {
                System.out.println(e);
                e.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {

            }
        }
    }
}