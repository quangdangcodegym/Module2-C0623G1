package java_collection;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueCollection {


    public static void main(String[] args) {
        /**Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        queue.offer(5);
        queue.offer(2);
        queue.offer(10);
        queue.offer(10);
        //System.out.println(queue);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        System.out.println();
        Queue<Integer> queue2 = new LinkedList<>();
        queue2.offer(5);
        queue2.offer(2);
        queue2.offer(10);
        //System.out.println(queue);
        while (!queue2.isEmpty()) {
            System.out.println(queue2.poll());
        }**/
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(2);
        queue.offer(3);
        queue.offer(1);
        queue.offer(4);
        queue.offer(5);
//        while (!queue.isEmpty()) {
//            System.out.println(queue.poll());
//        }
        System.out.println(queue.toString());

    }
}
