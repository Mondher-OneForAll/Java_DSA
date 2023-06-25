package MultiThreading;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GettingPrices_mThread {
    public static void main(String[] args) throws InterruptedException {


        String productID = "AGT123RDQZ98PM";
        for (Integer price : getPrices(productID)){
            System.out.println(price + "€");
        }
    }
    public static Set<Integer> getPrices(String productID) throws InterruptedException {
        Set<Integer> prices =Collections.synchronizedSet(new HashSet<>());
        CountDownLatch latch = new CountDownLatch(3);
        String[] urls = new String[3];
        urls[0] = "lowPrice";
        urls[1] = "MiddlePrice";
        urls[2] = "highPrice";
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++){
            executor.submit(new task(i, productID, urls[i], latch, prices));
        }

        executor.shutdown();
        try {
            latch.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {

        }
        System.out.println("Prices has been gathered");


        return prices;
    }
}

class task implements Runnable{
    private int id;
    private String productID;
    String url;
    CountDownLatch latch;
    Set<Integer> prices;
    task(int id, String productID, String url, CountDownLatch latch, Set<Integer> prices){
        this.id = id;
        this.productID = productID;
        this.url = url;
        this.latch = latch;
        this.prices = prices;
    }

    @Override
    public void run(){
        if (id == 0){
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {

            }
            prices.add(1000);
        }
        else if (id == 1){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {

            }
            prices.add(2000);
        }
        else{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            prices.add(3000);
        }

        latch.countDown();
    }
}



