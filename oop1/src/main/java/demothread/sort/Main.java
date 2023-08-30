package demothread.sort;

public class Main {
    public static void main(String[] args) {
        int [] arr = ArrayUtils.createArray(1000000, 1000000, 10);
//        ArrayUtils.interchangeSort(arr);

//        Thread thread = new SortThread(arr);
//        thread.start();

        Runnable r = new RunableSort(arr);
        Thread t = new Thread(r);
        t.start();

        System.out.println("Đi massage");

    }
}
