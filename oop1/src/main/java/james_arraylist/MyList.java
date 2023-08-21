package james_arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyList<E> implements Cloneable{
    private int size = 0;
    private int DEFAULT_CAPACITY = 5;
    private Object [] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < size; i++) {
            str += elements[i];
            if (i == size-1) {
                str += "]";
            }else{
                str += ",";
            }
        }
        return str;
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size] = e;
        size++;
    }

    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);

        MyList<Integer> myList = new MyList();
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);
        myList.add(8);

        myList.remove(1);
        System.out.println(myList);


        List<Integer> l = new ArrayList<>();


//        Collections.copy(l, Arrays.asList(3, 4, 5, 6 ));
        l.addAll(Arrays.asList(3, 4, 5, 6 ));

        l.add(10);
        System.out.println(l);






    }
}
