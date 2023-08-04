package sort;

public class Recuise {
    public static void main(String[] args) {
        int a = 5;
        // 5 = 5*4*3*2*1;

        int result = getFactorial(5);
        System.out.println("Giai thua: " + result);




    }

    public static int getFactorial(int number) {
        if (number == 1) {
            return 1;
        }
        return number * getFactorial(number - 1);
    }

    public int fatorial(int number) {
        int p = 1;
        for (int i = 1; i <= number; i++) {
            p *= i;
        }

        System.out.println("Giai thừa p: " + p);

        return p;
    }
}
