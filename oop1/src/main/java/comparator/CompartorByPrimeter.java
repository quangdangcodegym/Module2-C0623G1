package comparator;

import java.util.Comparator;

public class CompartorByPrimeter implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        if (o1.getPrimeter() > o2.getPrimeter()) {
            return 1;
        } else if (o1.getPrimeter() < o2.getPrimeter()) {
            return -1;
        }else {
            return 0;
        }
    }
}
