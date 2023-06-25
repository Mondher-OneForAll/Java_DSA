package String_Matching;

import java.time.Instant;
import java.util.SortedMap;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        String text = "Now is the time for all people to come to the aid of their party. Now is the time for all good people to\n" +
                "come to the aid of their party. Now is the time for many good people to come to the aid of their party.\n" +
                "Now is the time for all good people to come to the aid of their party. Now is the time for a lot of good\n" +
                "people to come to the aid of their party. Now is the time for all of the good people to come to the aid of\n" +
                "their party. Now is the time for all good people to come to the aid of their party. Now is the time for\n" +
                "each good person to come to the aid of their party. Now is the time for all good people to come to the aid\n" +
                "of their party. Now is the time for all good Republicans to come to the aid of their party. Now is the\n" +
                "time for all good people to come to the aid of their party. Now is the time for many or all good people to\n" +
                "come to the aid of their party. Now is the time for all good people to come to the aid of their party. Now\n" +
                "is the time for all good Democrats to come to the aid of their party. Now is the time for all people to\n" +
                "come to the aid of their party. Now is the time for all good people to come to the aid of their party. Now\n" +
                "is the time for many good people to come to the aid of their party. Now is the time for all good people to\n" +
                "come to the aid of their party. Now is the time for a lot of good people to come to the aid of their\n" +
                "party. Now is the time for all of the good people to come to the aid of their party. Now is the time for\n" +
                "all good people to come to the aid of their attack at dawn party. Now is the time for each person to come\n" +
                "to the aid of their party. Now is the time for all good people to come to the aid of their party. Now is\n" +
                "the time for all good Republicans to come to the aid of their party. Now is the time for all good people\n" +
                "to come to the aid of their party. Now is the time for many or all good people to come to the aid of their\n" +
                "party. Now is the time for all good people to come to the aid of their party. Now is the time for all good\n" +
                "Democrats to come to the aid of their party.";
        String pattern = "attack at dawn";
        CyclicBarrier barrier = new CyclicBarrier(4);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Knuth_Morris_Pratt knuth_morris_pratt = new Knuth_Morris_Pratt();
                try {
                    barrier.await();
                } catch (InterruptedException e) {

                } catch (BrokenBarrierException e) {

                }
                System.out.println(Instant.now() + " : Knuth_Morris_Pratt : the first occurrence is in index : "
                        + knuth_morris_pratt.KMP(text, pattern));
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Boyer_Moore boyer_moore = new Boyer_Moore();

                try {
                    barrier.await();
                } catch (InterruptedException e) {

                } catch (BrokenBarrierException e) {

                }

                System.out.println(Instant.now() + " : Boyer_Moore : the first occurrence is in index : "
                        + boyer_moore.boyerMoore(text, pattern));
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                Brute_Force brute_force = new Brute_Force();

                try {
                    barrier.await();
                } catch (InterruptedException e) {

                } catch (BrokenBarrierException e) {

                }

                System.out.println(Instant.now() + " : Brute Force : the first occurrence is in index : "
                        + brute_force.bruteForce(text, pattern));
            }
        });

        t1.start();
        t2.start();
        t3.start();

        barrier.await();



    }
}
class KMP implements Runnable{
    private String text;
    private String pattern;


    KMP(String text, String pattern){
        this.text = text;
        this.pattern = pattern;
    }

    @Override
    public void run() {

        Knuth_Morris_Pratt knuth_morris_pratt = new Knuth_Morris_Pratt();

        System.out.println("Knuth_Morris_Pratt : the first occurrence is in index : "
                    + knuth_morris_pratt.KMP(text, pattern));

    }
}

class BM implements Runnable{
    private String text;
    private String pattern;


    BM(String text, String pattern){
        this.text = text;
        this.pattern = pattern;
    }

    @Override
    public void run() {

        Boyer_Moore boyer_moore = new Boyer_Moore();

        System.out.println("Boyer_Moore : the first occurrence is in index : "
                    + boyer_moore.boyerMoore(text, pattern));

    }
}
