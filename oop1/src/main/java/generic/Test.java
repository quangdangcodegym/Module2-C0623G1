package generic;

public class Test {
    public static <E> E[] printArray1(E[] elements) {
        for (E element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
        return elements;
    }
}
