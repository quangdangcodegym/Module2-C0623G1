package james_stack;

import java.util.Arrays;
import java.util.Stack;

public class StackMain {
    public static void main(String[] args) {
        int number = 16;

        System.out.println(timNhiPhan(number));

    }

    private static String timNhiPhan(int number) {
        if (number == 0) {
            return "0";
        } else{
            if (number % 2 == 0) {
                return timNhiPhan(number / 2) + "0";
            }else{
                return timNhiPhan(number / 2) + "1";
            }
        }
    }

    public void reverseArray(int [] arr) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++){
            stack.push(arr[i]);
        }


        int i = 0;
        while (!stack.isEmpty()) {
            arr[i] = stack.pop();
            i++;
        }

        System.out.println(Arrays.toString(arr));
    }

    public void nhiphan(int number) {
        Stack<Integer> stack = new Stack<>();
        while ((number / 2) >= 1) {
            int i = number % 2;
            stack.push(i);
            number = number / 2;

        }

        String str = "";
        while (!stack.isEmpty()) {
            str += stack.pop();
        }

        System.out.println("Nhị phân: " + "1" + str);
    }
}
