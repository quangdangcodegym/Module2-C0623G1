package demo_socket_manager.controller;


import demo_socket_manager.model.Product;
import demo_socket_manager.model.Student;
import demo_socket_manager.service.StudentService;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class StudentController extends Controller{
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

            // Sử dụng đối tượng DecimalFormat để làm tròn số
            response.setStatusCode("OK");
            response.setData(studentService.getStudents());

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
    public void init() {
        studentService = StudentService.getInstance();
    }
}
