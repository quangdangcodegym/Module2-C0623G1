package equal_hashcode;

import shape.Circle;
import stopwatch.StopWatch;

import java.util.Objects;

public class Rectangle extends Shape {
    private double height;      // 0.0
    private double width;

    public Rectangle(String color, boolean filled, double w, double h) {
        super(color, filled);
        this.width = w;
        this.height = h;
    }



    /**
    @Override
    public boolean equals(Object obj) {
        Rectangle r2 = (Rectangle) obj;

        if (this.width == r2.width && this.height == r2.height
                && this.color.equals(r2.color) && this.filled == r2.filled) {
            return true;
        }
        return false;
    }

    **/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.height, height) == 0 && Double.compare(rectangle.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width);
    }
}
