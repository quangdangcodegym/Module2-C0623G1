package list_arraylist;


import java.util.Comparator;

public class ComparatorByArea implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
        Rectangle o1 = (Rectangle) s1;
        Rectangle o2 = (Rectangle) s2;
        if (o1.getArea() > o2.getArea()) {
            return 1;
        } else if (o1.getArea() < o2.getArea()) {
            return -1;
        }else {
            return 0;
        }
    }
}
