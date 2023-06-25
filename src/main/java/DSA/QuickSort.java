package DSA;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {9,5,1,2,3,7,4,8,6};

        quickSort(array, 0, array.length - 1);
        for (int i : array) System.out.print("\t" + i);
    }

    private static void quickSort(int[] array, int start, int end) {

        if (end <= start) return;//Base case
        int pivot = partition(array, start, end);

        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int start, int end) {

        int i = start - 1;
        int pivot = array[end];

        for (int j = start; j <= end - 1; j++){
            if (array[j] < pivot){
                i++;
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        i++;
        int tmp = array[i];
        array[i] = array[end];
        array[end] = tmp;

        return i;
    }
}
