package demo_socket_manager.controller;

import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Response implements Serializable {
    private String method;
    private String statusCode;

    private Object data;
    private transient ObjectOutputStream  objectOutputStream;

    public Response(String method, String statusCode, Object data) {
        this.method = method;
        this.statusCode = statusCode;
        this.data = data;
    }

    public Response() {
    }

    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

    public void setObjectOutputStream(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "method='" + method + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", data=" + data +
                '}';
    }
}
