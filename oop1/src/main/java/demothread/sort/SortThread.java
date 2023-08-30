package demothread.sort;

public class SortThread extends Thread{
    private int [] arr;
    @Override
    public void run() {
        ArrayUtils.interchangeSort(arr);
    }

    public SortThread(int[] arr) {
        this.arr = arr;
    }
}
