package MultiThreading;

public class MultiThread extends Thread{
    private int threadNumber;
    public MultiThread(){}
    public MultiThread(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < 1000000; i++){
            sum += i;
            System.out.println(i + " From thread " + threadNumber);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(sum);

    }
}
