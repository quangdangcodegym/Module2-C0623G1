package stream_dahinh;

import nhanvien.PrintUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(String color, boolean filled, int width, int height) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public int getArea() {
        return this.height*this.height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int xyz(Rectangle r2){
        if (this.getArea() > r2.getArea()) {
            return 1;
        } else if (this.getArea() < r2.getArea()) {
            return -1;
        }else {
            return 0;
        }
    }
    public boolean ddd() {
        if(String.valueOf(this.getWidth()).contains("5")){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {



        Rectangle e = new Rectangle("RED", false, 5, 5);
        Rectangle e1 = new Rectangle("RED", false, 1, 5);
        Rectangle e2 = new Rectangle("RED", false, 5, 5);

        List<Rectangle> rectangles = Arrays.asList(e, e1);
        /**
        rectangles.stream().max(new Comparator<Rectangle>() {
            @Override
            public int compare(Rectangle o1, Rectangle o2) {
                if (o1.getArea() > o2.getArea()) {
                    return 1;
                } else if (o1.getArea() < o2.getArea()) {
                    return -1;
                }else{
                    return 0;
                }
            }
        });


         Instance method reference: (obj[EType], args) -> obj.instanceMethod(args)
                                Ngắn gọn:   EType::instanceMethod
                                            (o1, o2) -> o1.xyz(o2)
                                            Rectangle::xyz

        Rectangle r = rectangles.stream().max((o1, o2) -> {
            if (o1.getArea() > o2.getArea()) {
                return 1;
            } else if (o1.getArea() < o2.getArea()) {
                return -1;
            }else{
                return 0;
            }
        }).get();

//        PrintUtils p = new PrintUtils();

        rectangles.stream().max(PrintUtils::xxx);


        rectangles.stream().max(Rectangle::xyz);

         */
        Predicate p;
        boolean check = rectangles.stream().anyMatch(new Predicate<Rectangle>() {
            @Override
            public boolean test(Rectangle rectangle) {
                if(String.valueOf(rectangle.getWidth()).contains("5")){
                    return true;
                }
                return false;
            }
        });

        boolean check2 = rectangles.stream().anyMatch((rectangle -> String.valueOf(rectangle.getWidth()).contains("5")));
        boolean check3 = rectangles.stream().anyMatch(PrintUtils::uuu);

        /**
         Instance method reference: (obj[EType], args) -> obj.instanceMethod(args)
         Ngắn gọn: EType::instanceMethod
         */
        boolean check4 = rectangles.stream().anyMatch(Rectangle::ddd);

        System.out.println("CHECK: " + check);



    }
}
