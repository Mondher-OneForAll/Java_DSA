package DSA;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {9,5,7,3,2,4,6,1,8};
        long startTime;
        long endTime;
        long elapsedTime;

        startTime = System.nanoTime();
        selectionSort(array);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        System.out.println("Selection Sort took  : " + elapsedTime + " ns");

        for (int i : array) System.out.print("\t" + i);
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++){
            int min = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[min] > array[j]){
                    min = j;
                }
            }
            int tmp = array[i];
            array[i] = array[min];
            array[min] = tmp;
        }
    }
}
