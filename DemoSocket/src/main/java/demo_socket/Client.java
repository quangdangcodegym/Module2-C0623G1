package demo_socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class Client {
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

            //Request(String requestId, String method, String action, String controller, ObjectInputStream objectInputStream, Object data)
            Request request = new Request(null, "GET", "show", "/product", is, null);
            os.writeObject(request);
            os.flush();


            Object objRes = is.readObject();
            if (objRes != null) {
                Response resp = (Response) objRes;

                System.out.println("NHẬN THÔNG TIN TỪ SERVER: " + resp);
            }


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


    public static void main(String[] args) {
        Client client = new Client();
    }
}
