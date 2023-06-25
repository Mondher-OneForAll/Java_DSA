package DSA;

import java.util.*;

public class PriorityQueuesDemo {
    public static void main(String[] args) {
        Queue<Double> grades = new PriorityQueue<>(Collections.reverseOrder());

        grades.offer(3.0);
        grades.offer(4.0);
        grades.offer(1.5);
        grades.offer(2.5);
        grades.offer(2.0);

        Queue<String> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer("D");
        priorityQueue.offer("F");
        priorityQueue.offer("A");
        priorityQueue.offer("C");
        priorityQueue.offer("B");

        //System.out.println(grades.isEmpty());
        //System.out.println(grades);

        while (!grades.isEmpty()){
            System.out.print(grades.poll() + " => ");
            System.out.println(priorityQueue.poll());
        }
    }
}
