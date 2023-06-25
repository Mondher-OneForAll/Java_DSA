package DSA;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {9,5,7,3,2,4,6,1,8};
        long startTime;
        long endTime;
        long elapsedTime;

        startTime = System.nanoTime();
        insertionSort(array);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        System.out.println("Insertion Sort took  : " + elapsedTime + " ns");

        for (int i : array) System.out.print("\t" + i);
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++){
            int tmp = array[i];

            int j = i - 1;
            while (j >= 0 && array[j] > tmp){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
    }
}
