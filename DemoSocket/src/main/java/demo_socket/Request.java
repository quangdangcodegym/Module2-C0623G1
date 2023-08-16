package demo_socket;

import java.io.ObjectInputStream;
import java.io.Serializable;


public class Request implements Serializable {

    private String requestId;
    private String method;      // GET, POST
    private String action;      // CRUD
    private String controller;  // /nhanvien  | /product
    private transient ObjectInputStream  objectInputStream = null;

    private Object data;

    public Request() {
    }

    public Request(String requestId, String method, String action, String controller, ObjectInputStream objectInputStream, Object data) {
        this.requestId = requestId;
        this.method = method;
        this.action = action;
        this.controller = controller;
        this.objectInputStream = objectInputStream;
        this.data = data;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public void setObjectInputStream(ObjectInputStream objectInputStream) {
        this.objectInputStream = objectInputStream;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
