package demo_socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Client {
    private Scanner scanner = new Scanner(System.in);
    public Client(){
        final String serverHost = "localhost";
        Socket socketOfClient = null;
        ObjectInputStream is = null;
        ObjectOutputStream os = null;
        try {
            socketOfClient = new Socket(serverHost, 9999);
            os = new ObjectOutputStream(socketOfClient.getOutputStream());
            is = new ObjectInputStream(socketOfClient.getInputStream());

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + serverHost);
            return;
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + serverHost);
            return;
        }

        try {
            launcher(is, os);

            os.close();
            is.close();
            socketOfClient.close();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (UnknownHostException e) {
            System.err.println("Trying to connect to unknown host: " + e);
        } catch (IOException e) {
            System.err.println("IOException:  " + e);
        }
    }

    private void launcher(ObjectInputStream is, ObjectOutputStream os) throws ClassNotFoundException, UnknownHostException, IOException{
        System.out.println("MENU chương trình");
        System.out.println("Nhập 1. Xem danh sách");
        System.out.println("Nhâp 2. Quản lý products");


        int action = Integer.parseInt(scanner.nextLine());
        switch (action) {
            case 1:{
                showProducts(is, os);
                break;
            }
            case 2:{
                showProductAdd(is, os);
            }

        }
        //Request(String requestId, String method, String action, String controller, ObjectInputStream objectInputStream, Object data)

    }

    private void showProductAdd(ObjectInputStream is, ObjectOutputStream os) {
    }

    private void showProducts(ObjectInputStream is, ObjectOutputStream os) throws ClassNotFoundException, UnknownHostException, IOException{
        Request request = new Request(null, "GET", "show", "/product", is, null);
        os.writeObject(request);
        os.flush();


        Object objRes = is.readObject();
        if (objRes != null) {
            Response resp = (Response) objRes;
            System.out.println("NHẬN THÔNG TIN TỪ SERVER: " + resp);
            List<Product> products  = (List<Product>) resp.getData();
            products.stream().forEach(System.out::println);
        }
    }


    public static void main(String[] args) {
        Client client = new Client();
    }
}
