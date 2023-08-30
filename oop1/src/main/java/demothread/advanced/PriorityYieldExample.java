package demothread.advanced;

public class PriorityYieldExample {
    public static void main(String[] args) {


        Thread hightPriorityThread = new Thread(new PriorityYieldExample.PriorityTask("High Priority"));
        Thread lowPriorityThread = new Thread(new PriorityYieldExample.PriorityTask("Low Priority"));
        hightPriorityThread.setPriority(Thread.MIN_PRIORITY);
        lowPriorityThread.setPriority(Thread.MAX_PRIORITY);


        hightPriorityThread.start();
        lowPriorityThread.start();
    }

    static class PriorityTask implements Runnable {
        private String name;

        public PriorityTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(name + " - Iteration " + i);
                // Nhường CPU cho các luồng khác
                Thread.yield();
            }
        }
    }
}