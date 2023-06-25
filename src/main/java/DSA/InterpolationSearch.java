package DSA;

import java.nio.file.attribute.UserPrincipalLookupService;

public class InterpolationSearch {
    public static void main(String[] args) {

        int[] array = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512,1024,2048,4096};

        long startTime;
        long endTime;
        long elapsedTime;

        startTime = System.nanoTime();
        int index = interpolationSearch(array, 8);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        if (index != -1) System.out.println("Element was found at index : " + index + " in " + elapsedTime + " ns");
        else System.out.println("Not found, it took " + elapsedTime + " ns");


    }

    private static int interpolationSearch(int[] array, int value) {
        int high = array.length - 1;
        int low = 0;

        while (value >= array[low] && value <= array[high] && low <= high) {
            int probe = low + (high - low) * (value - array[low]) / (array[high] - array[low]);
            System.out.println("Probe : " + probe);

            if (value < array[probe]) high = probe - 1;
            else if (value > array[probe]) low = probe + 1;
            else return probe;

        }
        return -1;
    }
}