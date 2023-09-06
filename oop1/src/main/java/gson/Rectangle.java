package gson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shape.Circle;
import stopwatch.StopWatch;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rectangle extends Shape {
    private double height;      // 0.0
    private double width;



    public Rectangle(String color, boolean filled) {
        this.filled = filled;
//        this.color = color;
        this.setColor(color);
        super.setColor(color);
    }
    public Rectangle(String color, boolean filled, double w, double h) {
//        super();
//        super(color, filled);           // super: gọi đến contructor/phương thức/thuộc tính của lớp cha
//        this.filled = filled;
//        this.color = color;
//        super.color = color;
        super.setColor(color);
        super.filled = filled;
        this.width = w;
        this.height = h;
    }
    /**
    public String showHang(){
        return "Color: " + this.color + " filled: " + this.filled;
    }
     **/
    public String showHang(){
        return "Color: " + this.getColor() + " filled: " + this.filled + " w: " + this.width + " h:" + this.height;
    }

    @Override
    public void setColor(String color) {
        this.setColor("COLOR: " + color);
    }

    public double getArea() {
        return this.height * this.height;
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle("RED", true, 5.0, 10.0);
        Rectangle r2 = new Rectangle("RED", true, 5.0, 10.0);

        // Quang -> sdfjbsdlfbvnsdf24234
        // 123 -->fbsfbs124e234

        System.out.println(r2.toString());       // shape.Rectangle + @ Integer.toHexString(hashcode(địa chỉ của đối tượng))
        System.out.println();


        Shape s1 = new Shape();
        Object s2 = new Rectangle("BLUE", false, 10, 10);

//        System.out.println(s2.toString());
//        System.out.println(rectangle.getArea());

        // Biên dịch (toString() theo kiểu khai báo) <-> runtine (toString theo kiểu thực tế)
        if (s2 instanceof Rectangle) {
            System.out.println("LA KIEU RECTANGLE");
        }
        if (s2 instanceof Shape) {
            System.out.println("LA KIEU SHAPE");
        }
        if (s2 instanceof Object) {
            System.out.println("LA KIEU OBJECT");
        }

        if (s2 instanceof StopWatch) {
            System.out.println("KHONG PHAI LA KIEU STOP WATCH");
        }
        if (s2 instanceof Circle) {
            System.out.println("KHONG PHAI LA KIEU CIRCLE");
        }





    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }
}
