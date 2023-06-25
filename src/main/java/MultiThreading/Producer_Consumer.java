package MultiThreading;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer_Consumer {
    public static void main(String[] args) throws InterruptedException {

        MyBlockingQueue queue = new MyBlockingQueue(10);
        while (true) {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    Random random = new Random();
                    int value = random.nextInt(100);
                    try {
                        queue.put(value);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        queue.take();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            t1.start();
            t2.start();
            //t1.join();
            //t2.join();
        }

    }
}
