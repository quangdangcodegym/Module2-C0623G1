package demo_socket_notify;

import demo_socket_notify.controller.Request;
import demo_socket_notify.controller.Response;
import demo_socket_notify.model.Product;
import demo_socket_notify.model.Student;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;

public class Client {

    private SharedResource sharedResource;
    private Scanner scanner = new Scanner(System.in);
    ObjectInputStream is = null;
    ObjectOutputStream os = null;

    Socket socketOfClient = null;
    Request request ;
    public Client(){
        final String serverHost = "localhost";
        sharedResource = new SharedResource();
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
            Thread readerThread = new ReaderThread();
            readerThread.start();


            launcher(is, os);
            os.close();
            is.close();
            socketOfClient.close();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (UnknownHostException e) {
            System.err.println("Trying to connect to unknown host: " + e);
        } catch (IOException e) {
            System.err.println("IOException:  " + e);
        }
    }

    private  void launcher(ObjectInputStream is, ObjectOutputStream os) throws ClassNotFoundException, IOException, InterruptedException{
        boolean checkAction = false;
        do{
            sharedResource.setClientRequested();


            System.out.println("MENU chương trình");
            System.out.println("Nhập 1. Xem danh sách sản phẩm");
            System.out.println("Nhâp 2. Thêm sản pham");
            System.out.println("Nhập 3. Xem danh sách học sinh");
            System.out.println("Nhập 4. Thêm học sinh");
            System.out.println("Mời chọn: ");
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
                    break;
                }
                case 4:{
                    notifyClient(is, os);
                    break;
                }
            }
            sharedResource.waitReceiveResponse();
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

    private void notifyClient(ObjectInputStream is, ObjectOutputStream os)throws ClassNotFoundException, IOException {
        System.out.println("Notify đến client: ");
        String name = scanner.nextLine();


        request = new Request(null, "POST", "notify", "/notify", is, name);
        os.writeObject(request);
        os.flush();


    }

    private void showStudents(ObjectInputStream is, ObjectOutputStream os) throws ClassNotFoundException, IOException {
        request = new Request(null, "GET", "show", "/student", is, null);
        os.writeObject(request);
        os.flush();

    }

    private void addProduct(ObjectInputStream is, ObjectOutputStream os) throws ClassNotFoundException, IOException{
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();

        Product p = new Product();
        p.setName(name);

        request = new Request(null, "POST", "create", "/product", is, p);
        os.writeObject(request);
        os.flush();



    }

    private void showProducts(ObjectInputStream is, ObjectOutputStream os) throws ClassNotFoundException, IOException{
        request = new Request(null, "GET", "show", "/product", is, null);
        os.writeObject(request);
        os.flush();

    }


    public static void main(String[] args) {
        Client client = new Client();
    }

    class ReaderThread extends Thread {
        @Override
        public  void run() {
            try {
                boolean check = true;
                while (check) {
                    Object objRes = is.readObject();
                    if (objRes != null) {
                        Response resp = (Response) objRes;
                        System.out.println("NHẬN THÔNG TIN TỪ SERVER: " + resp);
                        switch (resp.getController()) {
                            case "/product": {
                                if (resp.getAction().equals("show")) {
                                    List<Product> products = (List<Product>) resp.getData();
                                    products.stream().forEach(System.out::println);
                                }
                                if (resp.getAction().equals("create")) {
                                    System.out.println(resp);
                                }
                                break;
                            }
                            case "/student": {
                                if (resp.getAction().equals("show")) {
                                    List<Student> students = (List<Student>) resp.getData();
                                    students.stream().forEach(System.out::println);
                                }
                                break;
                            }
                            case "/notify": {
                                System.out.println(resp);
                            }
                        }
                    }
                    sharedResource.setReceiveResponse();
                }
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    class SharedResource {
        private boolean WAIT_RECEIVER_RESP = false;

        public synchronized void waitReceiveResponse() throws InterruptedException {
            while (!WAIT_RECEIVER_RESP) {
                wait(); // Chờ đến khi có thông báo
            }
        }

        public synchronized void setReceiveResponse() {
            WAIT_RECEIVER_RESP = true;
            notify(); // Báo thức một luồng đang chờ
        }
        public synchronized void setClientRequested() {
            WAIT_RECEIVER_RESP = false;
            notify(); // Báo thức một luồng đang chờ
        }
    }

}
