package threaddemo;

class SharedResource {
    private boolean flag = false;

    public synchronized void waitForFlag() throws InterruptedException {
        while (!flag) {
            System.out.println("waiting.............");
            wait(); // Chờ đến khi có thông báo
        }
        System.out.println("Flag is true. Proceeding.");
    }

    public synchronized void setFlag() {
        flag = true;
        notify(); // Báo thức một luồng đang chờ
    }

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread thread1 = new Thread(() -> {
            try {
                resource.waitForFlag();
                System.out.println("avavaaaaaaaaa");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {

            try {
                Thread.sleep(5000);
                resource.setFlag();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();
    }
}