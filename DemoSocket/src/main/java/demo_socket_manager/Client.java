package demo_socket_manager;

import demo_socket_manager.controller.Request;
import demo_socket_manager.controller.Response;
import demo_socket_manager.model.Product;
import demo_socket_manager.model.Student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;

public class Client {
    private Scanner scanner = new Scanner(System.in);
    Request request ;
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
        boolean checkAction = false;
        do{
            System.out.println("MENU chương trình");
            System.out.println("Nhập 1. Xem danh sách sản phẩm");
            System.out.println("Nhâp 2. Thêm sản pham");
            System.out.println("Nhập 3. Xem danh sách học sinh");
            System.out.println("Nhập 4. Thêm học sinh");
            int action = Integer.parseInt(scanner.nextLine());
            switch (action) {
                case 1:{
                    showProducts(is, os);
                    break;
                }
                case 2:{
                    addProduct(is, os);
                    break;
                }
                case 3:{
                    showStudents(is, os);
                }
            }
            System.out.println("Bạn có muốn dừng không Y/N");
            String continueAction = scanner.nextLine();
            switch (continueAction) {
                case "Y" -> {
                    checkAction = false;
                }
                case "N" -> {
                    checkAction =  true;
                }
            }
        }while (checkAction);
    }

    private void showStudents(ObjectInputStream is, ObjectOutputStream os) throws ClassNotFoundException, UnknownHostException, IOException {
        request = new Request(null, "GET", "show", "/student", is, null);
        os.writeObject(request);
        os.flush();


        Object objRes = is.readObject();

        if (objRes != null) {
            Response resp = (Response) objRes;
            System.out.println("NHẬN THÔNG TIN TỪ SERVER: " + resp);
            List<Student> students  = (List<Student>) resp.getData();
            students.stream().forEach(System.out::println);
        }
    }

    private void addProduct(ObjectInputStream is, ObjectOutputStream os) throws ClassNotFoundException, UnknownHostException, IOException{
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();

        Product p = new Product();
        p.setName(name);

        request = new Request(null, "POST", "create", "/product", is, p);
        os.writeObject(request);
        os.flush();

        Object objRes = is.readObject();
        if (objRes != null) {
            Response resp = (Response) objRes;
            System.out.println("NHẬN THÔNG TIN TỪ SERVER: " + resp);
            Product product  = (Product) resp.getData();
        }
        showProducts(is, os);

    }

    private void showProducts(ObjectInputStream is, ObjectOutputStream os) throws ClassNotFoundException, UnknownHostException, IOException{
        request = new Request(null, "GET", "show", "/product", is, null);
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
