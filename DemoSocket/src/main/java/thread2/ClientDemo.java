package thread2;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientDemo {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Địa chỉ máy chủ.
        final String serverHost = "localhost";

        Socket socketOfClient = null;
        ObjectOutputStream os = null;
        ObjectInputStream is = null;


        try {
            // Gửi yêu cầu kết nối tới Server đang lắng nghe
            // trên máy 'localhost' cổng 7777.
            socketOfClient = new Socket(serverHost, 9999);

            // Tạo luồng đầu ra tại client (Gửi dữ liệu tới server)
            os = new ObjectOutputStream(socketOfClient.getOutputStream());
            // Luồng đầu vào tại Client (Nhận dữ liệu từ server).
            is = new ObjectInputStream(socketOfClient.getInputStream());

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + serverHost);
            return;
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + serverHost);
            return;
        }

        try {
            boolean check = true;
            do {
//                System.out.println("Bạn muốn hình màu gì: ");
//                String color = scanner.nextLine();
//
//                os.writeObject(new Shape(color, false));
//                os.flush();

                Shape s = (Shape) is.readObject();
                System.out.println("Shape client: " + s);
            } while (check);

            os.close();
            is.close();
            socketOfClient.close();
        } catch (UnknownHostException e) {
            System.err.println("Trying to connect to unknown host: " + e);
        } catch (IOException e) {
            System.err.println("IOException:  " + e);
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println(classNotFoundException);
        }
    }

}