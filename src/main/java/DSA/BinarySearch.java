package DSA;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {

       int[] array = new int[10];
       int target = 7;

        System.out.println();

        for (int i = 0; i < array.length; i++) array[i] = i;

        long startTime;
        long endTime;
        long elapsedTime;

        startTime = System.nanoTime();
        int index = binarySearch(array, target);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        if (index != -1) System.out.println("Element was found at index : " + index + " in " + elapsedTime + " ns");
        else System.out.println("Not found, it took " + elapsedTime + " ns");


    }

    private static int binarySearch(int[] array, int target) {

        int low = 0;
        int high = array.length - 1;

        while (low <= high){

            int middle = low + (high - low)/2;
            System.out.println("Middle : " + middle);
            if (array[middle] > target) high = middle - 1;
            else if (array[middle] < target) low = middle + 1;
            else return middle;

        }
        return -1;
    }
}
