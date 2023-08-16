package java_collection;

import java.util.List;
import java.util.Stack;

public class StackCollection {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Thêm phần tử vào stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);


        stack.stream().forEach(System.out::println);

        // Lấy phần tử trên cùng của stack
//        System.out.println("Truoc khi dung pop");
//        int top1 = stack.peek();   //5
//        System.out.println("Top element: " + top1);
//        int num = stack.pop();
//        int num1 = stack.pop();
//
//        System.out.println("Sau khi dung pop");
//
//        int top2 = stack.peek();
//        System.out.println("Top element: " + top2); //3
//        stack.pop();
//        stack.pop();
//        stack.pop();
//
//        int top3 = stack.pop();
//
//        System.out.println("Top element: " +top3); //

    }
}
