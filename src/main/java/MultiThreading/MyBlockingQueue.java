package MultiThreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue {
    private int max;
    private Queue<Integer> queue;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition added = lock.newCondition();
    private Condition removed = lock.newCondition();
    MyBlockingQueue(int size){
        this.max = size;
        this.queue = new LinkedList<>();
    }

    public void put(Integer value) throws InterruptedException {
            lock.lock();
            try {
                while (queue.size() == max)
                    this.removed.await();

                this.queue.offer(value);
                Thread.sleep(1000);
                System.out.println("Element : " + value + " was added");
                this.added.signalAll();
            } finally {
                lock.unlock();
            }
    }

    public Integer take() throws InterruptedException {
            lock.lock();
            int tmp;

            try {
                while (queue.size() == 0)
                    this.added.await();

                tmp = queue.poll();
                Thread.sleep(1000);
                System.out.println("Element : " + tmp + " was removed");
                this.removed.signalAll();
                return tmp;
            } finally {
                lock.unlock();
            }

    }

    public void print(){
        System.out.print("null");
        for (int i : this.queue)
            System.out.print(" => " + i);
    }
}
