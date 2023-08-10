package abstract_interface;

import stopwatch.StopWatch;

public class Rectangle extends Shape {
    private double height;      // 0.0
    private double width;



    public Rectangle(String color, boolean filled) {
        this.filled = filled;
        this.setColor(color);
        super.setColor(color);
    }
    public Rectangle(String color, boolean filled, double w, double h) {
        super.setColor(color);
        super.filled = filled;
        this.width = w;
        this.height = h;
    }

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

    @Override
    public void resize(int percent) {
        this.height = this.height - this.height*percent/100;
        this.width = this.width - this.width*percent/100;
    }
}
