package DSA;

import java.util.Random;

public class LinearSearch {
    public static void main(String[] args) {
        int[] array = new int[1000000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(1000000) + 1;
            //System.out.println(array[i]);
        }
        long startTime;
        long endTime;
        long elapsedTime;

        startTime = System.nanoTime();
        int index  = linearSearch(array, 777777);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        if (index != -1) System.out.println("Element was found at index : " + index + " in " + elapsedTime + " ns");
        else System.out.println("Not found, it took " + elapsedTime + " ns");

    }

    private static int linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++){
            if (array[i] == value) return i;
        }
        return -1;
    }
}
