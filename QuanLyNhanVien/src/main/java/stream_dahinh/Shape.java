package stream_dahinh;

public class Shape {
    protected String color;
    protected boolean filled;

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public Shape() {
    }

    public int getArea() {
        return 0;
    }
}
