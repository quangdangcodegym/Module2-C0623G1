package equal_hashcode;

import java.util.Objects;

public class EqualHashcode {
    public static void main(String[] args) {

        /**
        Rectangle r1 = new Rectangle("RED", false, 5, 5);           // 0x3255
        Rectangle r2 = new Rectangle("RED", false, 5, 5);           // 0x6563


        if (r1 == r2) {
            System.out.println("DUNG == : 2 hình chu nhat bang nhau");
        }
        if (r1.equals(r2)) {
            System.out.println("DUNG EQUALS: 2 hình chu nhat bang nhau");
        }

        int a = 5;
        int b = 5;
        System.out.println("Số 5: " + Objects.hash(a));             // 36
        System.out.println("Số 5: " + Objects.hash(b));             // 36

        System.out.println("R1 hashcode: " + r1.hashCode());
        System.out.println("R2 hashcode: " + r2.hashCode());

         **/
        Rectangle r1 = new Rectangle("RED", false, 5, 5);           // 0x3255
        Rectangle r2 = new Rectangle("RED", false, 5, 5);           // 0x6563
        if (r1.equals(r2)) {
            System.out.println("DUNG EQUALS: 2 hình chu nhat bang nhau");
        }

        System.out.println("R1 hashcode: " + r1.hashCode());
        System.out.println("R2 hashcode: " + r2.hashCode());
    }
}
