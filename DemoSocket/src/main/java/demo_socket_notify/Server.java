package demo_socket_notify;




import demo_socket_notify.controller.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {
    private List<ServiceThread> serviceThreads;
    public Server(){
        serviceThreads = new ArrayList<>();
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

                String clientId = System.currentTimeMillis() % 10000 + "";
                System.out.println("Có client kết nối tới: " + clientId);
                serviceThreads.add(new ServiceThread(socketOfServer, clientId, this));
                serviceThreads.get(serviceThreads.size()-1).start();

            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }finally {
            try {
                listener.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void sendTo(String clientId, String message) {
        ServiceThread sThread = serviceThreads.stream()
                .filter(serviceThread -> serviceThread.getClientId().equals(clientId))
                .findFirst().get();

        System.out.println("Thực hiện gửi thông tin cho client: " + sThread.getClientId());
        sThread.sendMessage(message);
    }



    public static void main(String[] args) {
        Server server = new Server();

    }
}
