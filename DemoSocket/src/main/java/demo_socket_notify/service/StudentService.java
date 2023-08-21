package demo_socket_notify.service;


import demo_socket_notify.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> students;
    private StudentService() {
        students = new ArrayList<>();
        students.add(new Student(1L, "Quang Dang"));
        students.add(new Student(2L, "Long Vo"));
    }

    private  static StudentService INSTANCE_STUDENT_SERVICE;
    public static StudentService getInstance() {
        if (INSTANCE_STUDENT_SERVICE == null) {
            INSTANCE_STUDENT_SERVICE = new StudentService();
        }
        return INSTANCE_STUDENT_SERVICE;
    }
    public List<Student> getStudents() {
        return students;
    }

    public Student addStudent(Student student) {
        student.setId(getStudents().size());
        students.add(student);

        return students.get(students.size() - 1);
    }
}
