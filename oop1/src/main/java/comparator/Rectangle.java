package comparator;

public class Rectangle extends Shape {
    private double height;      // 0.0
    private double width;

    public Rectangle(String color, boolean filled, double w, double h) {
        super(color, filled);
        this.width = w;
        this.height = h;
    }
    public double getArea() {
        return this.height * this.width;
    }
    public double getPrimeter() {
        return (this.height + this.width)*2;
    }


}
