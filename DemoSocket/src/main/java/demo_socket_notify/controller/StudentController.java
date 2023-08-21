package demo_socket_notify.controller;


import demo_socket_notify.Server;
import demo_socket_notify.model.Student;
import demo_socket_notify.service.StudentService;

import java.io.IOException;
import java.util.List;

public class StudentController extends Controller {
    private StudentService studentService;
    private static StudentController INSTANCE_STUDENT_CONTROLLER;
    public static StudentController getInstance() {
        if (INSTANCE_STUDENT_CONTROLLER == null) {
            INSTANCE_STUDENT_CONTROLLER = new StudentController();
        }
        return INSTANCE_STUDENT_CONTROLLER;
    }

    @Override
    public void doGet(Request request, Response response) throws IOException {
        if(request.getAction().equals("show")){
            response.setStatusCode("OK");
            response.setData(studentService.getStudents());
            response.setAction("show");

            System.out.println("SERVER: gửi về thông tin " + studentService.getStudents());

            List<Student> temps = List.copyOf(studentService.getStudents());

            response.setData(temps);
            response.getObjectOutputStream().writeObject(response);
            response.getObjectOutputStream().flush();
        }
    }

    @Override
    public void doPost(Request request, Response response) throws IOException {

    }

    @Override
    public void init(Server context, Request request, Response response) {
        studentService = StudentService.getInstance();
        this.context = context;

        this.request = request;
        this.response = response;
        this.response.setController("/student");
    }
}
