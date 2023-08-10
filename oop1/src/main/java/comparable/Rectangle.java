package comparable;

public class Rectangle extends Shape implements Comparable<Rectangle> {
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


    @Override
    public int compareTo(Rectangle o) {
        if (this.getArea() > o.getArea()) {
            return 1;
        } else if (this.getArea() < o.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
    public int compareTo2(Rectangle o) {
        if (this.getArea() > o.getArea()) {
            return 1;
        } else if (this.getArea() < o.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
}
