package demothread.stopwatch;

public class SortThreadOuter extends Thread {
    int [] arr ;
    StopWatch.ArrayUtils arrayUtils;
    @Override
    public void run() {
        arrayUtils.interchangeSort(arr);
    }
    public SortThreadOuter(int []arr,StopWatch.ArrayUtils arrayUtils){
        this.arr=arr;
        this.arrayUtils=arrayUtils;
    }
}
