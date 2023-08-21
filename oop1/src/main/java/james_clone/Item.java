package james_clone;

import java.util.ArrayList;

public class Item implements Cloneable {
    public int id;
    public String name;
    public SubItem subItem;         // cần clone hắn
    public ArrayList<String> listRef;

    public Item(int id, String name, SubItem subItem, ArrayList<String> listRef) {
        this.id = id;
        this.name = name;
        this.subItem = subItem;
        this.listRef = listRef;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subItem=" + subItem +
                ", listRef=" + listRef +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
        Item cloneItem = (Item) super.clone();
        cloneItem.subItem = (SubItem) cloneItem.subItem.clone();
        cloneItem.listRef = (ArrayList<String>) cloneItem.listRef.clone();
        return cloneItem;
    }


    public static void main(String[] args) {
        /**
         TEST 1:
         ArrayList<String> listRef = new ArrayList<>();
         listRef.add("ref1");
         Item A = new Item(1, "A", new SubItem("SubA"), listRef);

         System.out.println(A);
         Item B = null;
         try {
         B = (Item) A.clone();

         System.out.println(B);
         } catch (CloneNotSupportedException e) {
         e.printStackTrace();
         }


         TEST 2:
         ArrayList<String> listRef = new ArrayList<>();
         listRef.add("ref1");
         Item A = new Item(1, "A", new SubItem("SubA"), listRef);

         Item B = null;
         try {
         B = (Item) A.clone();
         } catch (CloneNotSupportedException e) {
         e.printStackTrace();
         }
         System.out.println("A : " + A);
         System.out.println("B : " + B);

         B.listRef.clear();
         A.subItem.text = "changeText";
         A.name = "changeNameA";

         System.out.println("A change: " + A);
         System.out.println("B change: " + B);
         */


        ArrayList<String> listRef = new ArrayList<>();
        listRef.add("ref1");
        Item A = new Item(1, "A", new SubItem("SubA"), listRef);

        Item B = null;
        try {
            B = (Item) A.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("A : " + A);
        System.out.println("B : " + B);

        B.listRef.clear();
        A.subItem.text = "changeText";
        A.name = "changeNameA";

        System.out.println("A change: " + A);
        System.out.println("B change: " + B);

    }
}