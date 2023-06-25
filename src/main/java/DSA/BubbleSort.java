package DSA;

public class BubbleSort {
    public static void main(String[] args) {

        int[] array = {9,5,7,3,2,4,6,1,8};
        long startTime;
        long endTime;
        long elapsedTime;

        startTime = System.nanoTime();
        bubbleSort(array);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        System.out.println("Bubble Sort took  : " + elapsedTime + " ns");

        for (int i : array) System.out.print("\t" + i);
    }

    private static void bubbleSort(int[] array) {
        boolean changed;
        for (int i = 0; i < array.length - 1; i++){
            changed = false;
            for (int j = 0; j < array.length - i - 1; j++){
                int tmp;
                if (array[j] > array[j + 1]){
                    changed = true;
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }

            }
            if (!changed) break;
        }
    }
}
