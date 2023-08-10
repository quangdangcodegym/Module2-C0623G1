package shape;

public class Shape {
    // public : access modifier: private/default/protected/public
    // private: trong class
    // default: trong package
    // protected: trong lớp con kế thùa
    private String color;     // NULL thuộc tính của đối tượng/thuộc tính instance/biến instance/field
    public boolean filled;      //false


    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;

    }
    public Shape() {
        this.color = "WHITE";
        this.filled = false;

        System.out.println("KHOI TAO THANG CHA: SHAPE");
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return filled;
    }

//    @Override
//    public String toString() {
//        return "Color: " + this.color + " filled: " + this.filled;
//    }

    public void setColor(String color) {
        if(color.contains("XXX")){
            throw new RuntimeException("Color không hợp lệ");
        }
        this.color = color;
    }


    public String showHang(){
        return "Color: " + this.color + " filled: " + this.filled;
    }

    public static void main(String[] args) {
        //        shape.Shape s1 = new shape.Shape("RED", true);
////        shape.shape.Shape s2 = new shape.shape.Shape();
//
//
//        System.out.println(s1.filled);
//        System.out.println(s1.color);

        Shape s2 = new Shape();     // s2 =  0x555( new shape.Shape())
        System.out.println(s2);

        Shape s3;     //   s3 = NULL


//        s2.color = "XXX";

        s2.setColor("XXX");
    }
}
