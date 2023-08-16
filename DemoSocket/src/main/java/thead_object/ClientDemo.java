package thead_object;

import thead_object.nhanvien.Certificate;
import thead_object.nhanvien.Employee;
import thead_object.nhanvien.Experience;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ClientDemo {

    private  Request request;
    private Scanner scanner = new Scanner(System.in);

    public void init() {
        final String serverHost = "localhost";

        Socket socketOfClient = null;
        ObjectOutputStream os = null;
        ObjectInputStream is = null;

        try {
            socketOfClient = new Socket(serverHost, 9999);
            os = new ObjectOutputStream(socketOfClient.getOutputStream());
            is = new ObjectInputStream(socketOfClient.getInputStream());

        }catch (UnknownHostException e) {
            System.err.println("Don't know about host " + serverHost);
            return;
        }
        catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + serverHost);
            return;
        }
        try {

            boolean check = true;
            while (check){

                System.out.println("Chọn chức năng bạn muốn quản lý: ");
                System.out.println("Nhập 1. Quản lý nhân viên");
                System.out.println("Nhập 2. Quản lý sản phẩm");
                System.out.println("Nhập 3. Thoát");

                int action = Integer.parseInt(scanner.nextLine());
                switch (action) {
                    case 1:{
                        request = new Request(null, "GET", "menu", "/employee", null);
                        os.writeObject(request);
                        os.flush();

                        Object objResponse = is.readObject();

                        if (objResponse != null) {
                            System.out.println("NHẬN RESPONSE TỪ SERVER: " + objResponse);
                            Response response = (Response) objResponse;

                            System.out.println("DATA: " + response.getData());
                        }
                        System.out.println("Chọn: ");
                        int actionEmployee = Integer.parseInt(scanner.nextLine());
                        switch (actionEmployee) {
                            case 1:
                            {
                                Employee employee = new Experience(5L, "Lyly", LocalDate.now(), "0399578134", "lyly@gmail.com", 0,
                                null, 2, "English");

                                request = new Request(null, "POST", "create", "/employee", employee);
                                os.writeObject(request);
                                os.flush();

                                objResponse = is.readObject();
                                if (objResponse != null) {
                                    System.out.println("NHẬN RESPONSE TỪ SERVER CREATE: " + objResponse);
                                    Response response = (Response) objResponse;

                                    System.out.println("DATA SAU KHI CREATE: " + response.getData());
                                }
                            }
                        }
                        break;
                    }
                }
            }
            is.close();
            os.close();
            socketOfClient.close();
        } catch (UnknownHostException e) {
            System.err.println("Trying to connect to unknown host: " + e);
        } catch (IOException e) {
            System.err.println("IOException:  " + e);
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println(classNotFoundException);
        }
    }


    public static void main(String[] args) {
        ClientDemo clientDemo = new ClientDemo();
        clientDemo.init();
    }

}