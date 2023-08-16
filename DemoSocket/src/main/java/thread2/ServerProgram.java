package thread2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerProgram {

    public static void main(String args[]) throws IOException {

        ServerSocket listener = null;

        System.out.println("Server is waiting to accept user...");
        int clientNumber = 0;


        // Mở một ServerSocket tại cổng 7777.
        // Chú ý bạn không thể chọn cổng nhỏ hơn 1023 nếu không là người dùng
        // đặc quyền (privileged users (root)).
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
        private Scanner scanner = new Scanner(System.in);

        private int clientNumber;
        private Socket socketOfServer;

        public ServiceThread(Socket socketOfServer, int clientNumber) {
            this.clientNumber = clientNumber;
            this.socketOfServer = socketOfServer;

            // Log
            log("New connection with client# " + this.clientNumber + " at " + socketOfServer);
        }

        @Override
        public void run() {


            try {
                // Mở luồng vào ra trên Socket tại Server.
                ObjectInputStream is = new ObjectInputStream(socketOfServer.getInputStream());
                ObjectOutputStream os = new ObjectOutputStream(socketOfServer.getOutputStream());

                    // Đọc dữ liệu tới server (Do client gửi tới).
//                    System.out.println("Bắt đầu đọc dữ liệu");
//                    Shape shape = (Shape) is.readObject();
//                    System.out.println("REQUEST: " + shape);


                Thread.sleep(10000);
                System.out.println("Nhập màu: ");
                String name = scanner.nextLine();

                Shape shape = new Shape();
                shape.setColor("AAAA: " + name + Math.random());
                System.out.println("RESPONSE: " + shape);
                os.writeObject(shape);
                os.flush();



            } catch (IOException e) {
                System.out.println(e);
                e.printStackTrace();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}