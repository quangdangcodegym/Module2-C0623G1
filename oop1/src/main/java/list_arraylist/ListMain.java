package list_arraylist;

import sun.text.normalizer.UBiDiProps;

import java.util.*;
import java.util.stream.Collectors;

public class ListMain {
    public static void main(String[] args) {
        /**
        List<Shape> list = new ArrayList<>();

        Shape s1 = new Rectangle("RED", false, 5, 5);
        list.add(new Rectangle("RED", false, 15, 5));
        list.add(s1);
        list.add(new Rectangle("RED", false, 10, 5));


        System.out.println(list.indexOf(s1));


        List<String> list1 = new ArrayList<>();
        list1.add("Quang");
        list1.add("Long");

        list1 = new Stack<>();


        ArrayList<String> list2 = new ArrayList<>();
        list2 = new Stack<>();

         **/

        //        list.sort(new ComparatorByArea());

        List<Shape> list = new ArrayList<>();

        Shape s11 = new Rectangle("RED", false, 5, 5);
        list.add(new Rectangle("RED", false, 15, 5));
        list.add(s11);
        list.add(new Rectangle("RED", false, 10, 5));

        Comparator comparator = new ComparatorByArea();
        list.sort(comparator);


        list.sort(new ComparatorByArea());

        /**
        list.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {

                Rectangle o1 = (Rectangle) s1;
                Rectangle o2 = (Rectangle) s2;
                if (o1.getPrimeter() > o2.getPrimeter()) {
                    return 1;
                } else if (o1.getPrimeter() < o2.getPrimeter()) {
                    return -1;
                }else {
                    return 0;
                }
            }
        });

         **/
        list.sort((s1, s2) -> {

            Rectangle o1 = (Rectangle) s1;
            Rectangle o2 = (Rectangle) s2;
            if (o1.getPrimeter() > o2.getPrimeter()) {
                return 1;
            } else if (o1.getPrimeter() < o2.getPrimeter()) {
                return -1;
            }else {
                return 0;
            }
        });


        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        list1.add(7);


        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            list2.add(list1.get(i) * 2);
        }

        List<Integer> list3 = list1.stream().map(a -> a*2).collect(Collectors.toList());









    }
}
