package comparator;


import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle("RED", false, 5, 8);
        Rectangle r2 = new Rectangle("RED", false, 1, 1);
        Rectangle r3 = new Rectangle("RED", false, 1, 7);
        Rectangle r4 = new Rectangle("RED", false, 2, 3);


        Rectangle[] rectangles = new Rectangle[4];
        rectangles[0] = r1;
        rectangles[1] = r2;
        rectangles[2] = r3;
        rectangles[3] = r4;


//        Arrays.sort(rectangles);
        Comparator c = new CompartorByPrimeter();
        Arrays.sort(rectangles, c);
        System.out.println(Arrays.toString(rectangles));

    }
    /**
    public static void mySort(comparable.Rectangle[] rectangles, Comparator<Rectangle> comparator) {
        for (int i = 0; i < rectangles.length - 1; i++) {
            for (int j = i + 1; j < rectangles.length; j++) {
                if (comparator.compare(rectangles[i], rectangles[j]) < 0) {        // truu tuong: compare
                    Rectangle temp = rectangles[i];
                    rectangles[i] = rectangles[j];
                    rectangles[j] = temp;
                }
            }
        }
    }

     **/

    /**
    public static void mySort(Rectangle[] rectangles) {
        for (int i = 0; i < rectangles.length - 1; i++) {
            for (int j = i + 1; j < rectangles.length; j++) {
                if (rectangles[j].compareTo(rectangles[i])) {        // truu tuong: compareTo
                    // CODE  doi cho
                }
            }
        }
    }
    public static void mySort1(Rectangle[] rectangles) {
        for (int i = 0; i < rectangles.length - 1; i++) {
            for (int j = i + 1; j < rectangles.length; j++) {
                if (rectangles[j].getPrimeter() < rectangles[i].getPrimeter()) {        // truu tuong
                    // CODE  doi cho
                }
            }
        }
    }

     **/
}
