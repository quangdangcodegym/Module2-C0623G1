package threadcommunication;

public class SharedResource {
    private int value;
    private boolean produced = false; // sản xuất

    public synchronized void produce(int newValue) throws InterruptedException {
        while (produced) {
            System.out.println("produce: waiting");
            wait(); // Chờ đến khi consumer sử dụng dữ liệu
        }
        value = newValue;
        produced = true;
        System.out.println("Produced: " + value);
        notify(); // Thông báo cho consumer rằng có dữ liệu mới
    }

    public synchronized int consume() throws InterruptedException {
        while (!produced) {
            System.out.println("consume: waiting");
            wait(); // Chờ đến khi producer tạo dữ liệu
        }
        System.out.println("Consumed: " + value);
        produced = false;
        notify(); // Thông báo cho producer rằng dữ liệu đã được sử dụng
        return value;
    }
}
