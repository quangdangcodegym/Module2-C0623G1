import james_trycatch.Triangle;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)  {

        /**
        boolean check = false;
        do {
            try {
                System.out.println("Nhập a: ");
                int a = Integer.parseInt(scanner.nextLine());

                System.out.println("Nhập b: ");
                int b = Integer.parseInt(scanner.nextLine());

                System.out.println("Nhập c: ");
                int c = Integer.parseInt(scanner.nextLine());


                Triangle triangle = new Triangle(a, b, c);
            } catch (Exception e) {
                check = true;
                System.out.println(e.getMessage());
            }
        } while (check);

         **/
        Triangle triangle = new Triangle(-4, 4, 4);
        System.out.println(triangle);
    }
}
