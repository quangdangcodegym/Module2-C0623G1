package demothread.basic;

public class TaskThreadDemo {
    public static void main(String[] args) {

        /**
        int maxCharC = 100;

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < maxCharC; i++) {
                System.out.println('C');
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println('B');
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    System.out.println(" " + i);
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

         **/

        Thread t = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println('B');
                }
            }
        };
        t.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println('D');
                }
            }
        }.start();

    }
}
