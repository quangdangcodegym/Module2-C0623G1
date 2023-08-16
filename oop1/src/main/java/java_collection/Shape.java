package java_collection;

import java.util.Objects;

public class Shape {

    protected String color;
    protected boolean filled;


    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;

    }
    public Shape() {
        this.color = "WHITE";
        this.filled = false;

    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
    public void showHang() {
        System.out.println(toString()); ;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Shape shape = (Shape) o;
//        return filled == shape.filled && Objects.equals(color, shape.color);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(color, filled);
    }
}
