package demothread.advanced;

/**
 Trong Java, phương thức yield() được sử dụng trong đối tượng Thread để cho phép luồng hiện tại
 nhường bộ xử lý cho một luồng khác có độ ưu tiên cao hơn hoặc cùng độ ưu tiên với nó.
 Khi một luồng gọi phương thức yield(), nó thông báo cho bộ lập lịch rằng nó có thể nhường
 bộ xử lý cho bất kỳ luồng nào có cùng độ ưu tiên hoặc cao hơn. Tuy nhiên, việc thực sự nhường
 bộ xử lý cho luồng khác phụ thuộc vào bộ lập lịch của hệ thống, vì vậy không đảm bảo rằng
 luồng sẽ được chạy ngay lập tức.
 Việc sử dụng phương thức yield() có thể giúp cải thiện hiệu suất hệ thống khi có nhiều luồng
 đang chạy cùng một lúc, bởi vì nó giúp chia sẻ bộ xử lý của hệ thống giữa các luồng.
 Tuy nhiên, cũng cần lưu ý rằng việc sử dụng phương thức yield() có thể làm giảm hiệu suất
 của một số ứng dụng, đặc biệt là khi các luồng đang chạy trên các bộ xử lý đa nhân.
 */
public class YieldExample {
    /**

     Trong ví dụ này, chúng ta tạo ra hai luồng t1 và t2. Mỗi luồng chạy một vòng lặp với 5 lần lặp,
     in ra một chuỗi với tên của luồng và số thứ tự lặp. Trong vòng lặp, chúng ta sử dụng
     phương thức yield() để cho phép các luồng khác có thể chạy.
     Khi chúng ta chạy chương trình, ta sẽ thấy rằng các luồng sẽ chạy xen kẽ lẫn nhau
     thay vì chạy hoàn toàn riêng biệt. Khi một luồng gọi phương thức yield(),
     bộ lập lịch của hệ thống có thể chuyển bộ xử lý cho luồng khác để giúp tăng hiệu suất của hệ thống.
     */
    public static void main(String[] args) {
        // Tạo ra luồng thứ nhất
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 1 - " + i);
                // Nhường bộ xử lý cho luồng khác
                Thread.yield();
            }
        });
        t1.setPriority(1);

        // Tạo ra luồng thứ hai
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 2 - " + i);
                // Nhường bộ xử lý cho luồng khác
                Thread.yield();
            }
        });
        t2.setPriority(2);
        // Tạo ra luồng thứ hai
        Thread t3 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 3 - " + i);
                // Nhường bộ xử lý cho luồng khác
                Thread.yield();
            }
        });
        t3.setPriority(3);
        // Tạo ra luồng thứ hai
        Thread t4 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 4 - " + i);
                // Nhường bộ xử lý cho luồng khác
                Thread.yield();
            }
        });

        t4.setPriority(4);
        // Khởi động hai luồng
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}