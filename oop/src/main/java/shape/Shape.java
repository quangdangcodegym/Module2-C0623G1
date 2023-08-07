package shape;

public class Shape {
    // public : access modifier: private/default/protected/public
    // private: trong class
    // default: trong package
    // protected: trong lớp con kế thùa
    protected String color;     // NULL thuộc tính của đối tượng/thuộc tính instance/biến instance/field
    public boolean filled;      //false


    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;

    }
    public Shape() {
        this.color = "WHITE";
        this.filled = false;
    }

    public static void main(String[] args) {
        //        Shape s1 = new Shape("RED", true);
////        shape.Shape s2 = new shape.Shape();
//
//
//        System.out.println(s1.filled);
//        System.out.println(s1.color);

        Shape s2 = new Shape();     // s2 =  0x555( new Shape())
        System.out.println(s2.toString());

        Shape s3;     //   s3 = NULL
    }
}
