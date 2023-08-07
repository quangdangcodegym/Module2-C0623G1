package stopwatch;

public class Student {
    public static String college;          // thuộc tính của lớp
    private int id;                         // thuộc tính của đối tượng
    private String name;

    static {
        // khối khoi tạo static
        college = "KHOA HOC";
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void setCollege(String college) {
        System.out.println(Student.college);
        Student.college = college;


    }

    public void setCollege222(String college) {

    }

    public static void main(String[] args) {

        Student s1 = new Student(1, "Quang");
        Student s2 = new Student(2, "Quang1");
        Student s3 = new Student(3, "Quang2");
        Student s4 = new Student(4, "Quang3");
        Student s5 = new Student(5, "Quang4");
        Student s6 = new Student(6, "Quang5");


        System.out.println(Student.college);
        System.out.println(s1.college);
    }
}
