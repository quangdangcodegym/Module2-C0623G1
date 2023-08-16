package java_collection;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MapCollection {
    public static void main(String[] args) {
        Map<Integer, String > map = new TreeMap<>();
        map.put(1,"A");
        map.put(4,"B");
        map.put(2,"F");
        map.put(3,"D");
//        for (Map.Entry<Integer, String> entry : map.entrySet()) {
//            int key = entry.getKey();
//            String val = entry.getValue();
//            System.out.println("Key: " + key + ", Value: " + val);
//        }
//        map.keySet()
//        for(Integer key : map.keySet()){
//            System.out.println(key + map.get(key));
//        }

        String max =  map.values().stream().max(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.compareTo(o2) > 0){
                    return 1;
                } else if (o1.compareTo(o2) < 0) {
                    return -1;
                }
                return 0;
            }
        }).get();
        System.out.println(max);

        String max2 = map.values().stream().max((o1, o2) -> o1.compareTo(o2)).get();
        System.out.println(max2);

        String max3 = map.values().stream().max(String::compareTo).get();
        System.out.println(max3);

    }
}
