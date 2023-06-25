package MultiThreading;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MultiThread thread1 = new MultiThread(1);
        //Thread IntThread1 = new Thread(thread1);

        MultiThread thread2 = new MultiThread(2);
        //Thread IntThread2 = new Thread(thread2);

        thread1.start();
        thread2.start();
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {

        }

        thread1.interrupt();

    }

}
