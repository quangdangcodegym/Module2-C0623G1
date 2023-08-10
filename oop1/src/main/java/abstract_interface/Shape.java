package abstract_interface;

public abstract class Shape implements Resizeable{
    // public : access modifier: private/default/protected/public
    // private: trong class
    // default: trong package
    // protected: trong lớp con kế thùa
    private String color;     // NULL thuộc tính của đối tượng/thuộc tính instance/biến instance/field
    public boolean filled;      //false


    public abstract double getArea();

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
//        Shape s = new Shape();
    }
}
