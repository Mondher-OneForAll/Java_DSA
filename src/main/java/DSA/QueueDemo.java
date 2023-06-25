package DSA;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.offer("Karen");
        queue.offer("Chad");
        queue.offer("Bob");
        queue.offer("Fred");

        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());
        queue.poll();
        System.out.println(queue);
        System.out.println(queue.contains("Chad"));
    }
}
