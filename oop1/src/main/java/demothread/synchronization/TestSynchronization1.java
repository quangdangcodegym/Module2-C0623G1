package demothread.synchronization;

public class TestSynchronization1 {
    public static void main(String args[]) {
        Table obj = new Table();// tao mot object

         MyThread1 t1 = new MyThread1(obj);
         t1.start();

         MyThread2 t2 = new MyThread2(obj);
         t1.start();
         t2.start();

    }
}
