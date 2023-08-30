package demothread.sort;

public class RunableSort implements Runnable{
    private int [] arr;
    @Override
    public void run() {
        ArrayUtils.interchangeSort(arr);
    }

    public RunableSort(int[] arr) {
        this.arr = arr;
    }
}
