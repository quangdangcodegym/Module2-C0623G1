package james_arraylist;

import java.util.ArrayList;
import java.util.List;

public class Shape implements Cloneable{

    protected String color;
    protected boolean filled;

    protected List<Integer> ds = new ArrayList();

    private Hello h;


    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;

        ds.add(1);
        ds.add(5);

        h = new Hello(1);

    }
    public Shape() {
        this.color = "WHITE";
        this.filled = false;

    }

    public Shape copy() {
        return new Shape(this.color, this.filled);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Shape s = (Shape) super.clone();
        s.h = (Hello) s.h.clone();
        return s;
    }

    public static void main(String[] args) {
        try {
            Shape s = new Shape("RED", false);
            Shape s1 = (Shape) s.clone();

            System.out.println(s);
            System.out.println(s1);


            System.out.println("Hello object-------");
            System.out.println(s.h);
            System.out.println(s1.h);


        } catch (CloneNotSupportedException cloneNotSupportedException) {
            cloneNotSupportedException.printStackTrace();

        }

    }

}
