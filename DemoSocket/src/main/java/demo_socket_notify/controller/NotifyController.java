package demo_socket_notify.controller;

import demo_socket_notify.Server;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class NotifyController extends Controller{
    private static NotifyController INSTANCE_NOTIFY_CONTROLLER;
    public static NotifyController getInstance() {
        if (INSTANCE_NOTIFY_CONTROLLER == null) {
            INSTANCE_NOTIFY_CONTROLLER = new NotifyController();
        }
        return INSTANCE_NOTIFY_CONTROLLER;
    }

    @Override
    public void doGet(Request request, Response response) throws IOException {

    }

    @Override
    public void doPost(Request request, Response response) throws IOException {
        if(request.getAction().equals("notify")){
            response.setStatusCode("OK");

            String clientId = (String) request.getData();
            context.sendTo(clientId, "HAHA");

            response.setData("Đã gửi cho client: " + clientId);
            System.out.println("SERVER: gửi về thông tin ");
            response.getObjectOutputStream().writeObject(response);
            response.getObjectOutputStream().flush();
        }
    }

    @Override
    public void init(Server context, Request request, Response response) {
        this.context = context;
        this.request = request;
        this.response = response;
        this.response.setController("/notify");
    }
}
