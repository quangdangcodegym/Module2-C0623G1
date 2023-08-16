package java_collection;

import java.util.*;

public class SetCollection {
    public static void main(String[] args) {
        /**
        Set<String> java_collection.set = new HashSet<>();

        // Thêm phần tử vào HashSet
        java_collection.set.add("A");
        java_collection.set.add("B");
        java_collection.set.add("C");
        java_collection.set.add("A"); // Phần tử bị bỏ qua vì đã tồn tại trong java_collection.set

        // In ra các phần tử trong HashSet
        for (String element : java_collection.set) {
            System.out.println(element);
        }

        // Kiểm tra sự tồn tại của một phần tử
        boolean containsA = java_collection.set.contains("A");
        System.out.println("Set contains 'A': " + containsA);

        Set<String> java_collection.set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.compareTo(o2) > 0){
                    return 1;
                }else if(o1.compareTo(o2) < 0){
                    return -1;
                }
                return 0;
            }
        });

//        Set<String> set = new TreeSet<>((o1, o2) -> o1.compareTo(o2));
        Set<String> set = new TreeSet<>(String::compareTo);
        set.add("Quang");
        set.add("Vinh");
        set.add("Huy");
        set.add("Thang");
        for(String name : set){
            System.out.println(name);
        }
         **/

        Set<Shape> shapes = new HashSet<>();
        shapes.add(new Shape("Red", false));
        shapes.add(new Shape("Red", false));
        shapes.add(new Shape("Yellow", false));
        shapes.add(new Shape("Yellow", false));
//        for(Shape shape : shapes){
//            System.out.println(shape);
//        }
//        shapes.stream().forEach(shape -> System.out.println(shape.toString()));
        shapes.stream().forEach(Shape::showHang);
//        shapes.stream().forEach(System.out::println);


    }
}
