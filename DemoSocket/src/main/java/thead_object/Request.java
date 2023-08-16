package thead_object;

import java.io.ObjectInputStream;
import java.io.Serializable;

public class Request implements Serializable  {
    private String requestId;
    private String method;
    private String action;
    private String controller;
    ObjectInputStream objectInputStream = null;

    private Object data;

    public Request(String method, Object data) {
        this.method = method;
        this.data = data;
    }

    public Request(String requestId, String method, String action, Object data) {
        this.requestId = requestId;
        this.method = method;
        this.action = action;
        this.data = data;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public Request(String requestId, String method, String action, String controller, ObjectInputStream objectInputStream, Object data) {
        this.requestId = requestId;
        this.method = method;
        this.action = action;
        this.controller = controller;
        this.objectInputStream = objectInputStream;
        this.data = data;
    }

    public Request(String requestId, String method, String action, String controller, Object data) {
        this.requestId = requestId;
        this.method = method;
        this.action = action;
        this.controller = controller;
        this.data = data;
    }

    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public void setObjectInputStream(ObjectInputStream objectInputStream) {
        this.objectInputStream = objectInputStream;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Request(String requestId, String method, Object data) {
        this.requestId = requestId;
        this.method = method;
        this.data = data;
    }

    public Request() {
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
