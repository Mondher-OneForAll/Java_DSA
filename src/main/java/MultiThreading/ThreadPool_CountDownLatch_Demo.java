package MultiThreading;

import java.util.concurrent.*;

public class ThreadPool_CountDownLatch_Demo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(5);

        for (int i = 0; i < 5; i++){
            executor.submit(new Process(i, latch));
        }
        executor.shutdown();
        System.out.println("All Tasks submitted");
        latch.await();
        /*
        try {
            executor.awaitTermination(25, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

         */
        System.out.println("All Tasks finished");

    }

    public static class Process implements Runnable{

        private int id;
        CountDownLatch latch;
        Process(int id, CountDownLatch latch){
            this.id = id;
            this.latch = latch;
        }
        @Override
        public void run() {
            System.out.println("Starting thread : " + id);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            System.out.println("Completing thread : " + id);

            latch.countDown();
        }

    }
}
