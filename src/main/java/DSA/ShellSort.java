package DSA;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = {5, 8, 2, 13, 3, 7, 14, 6, 9, 12, 1, 10, 4, 11};
        shellSort(array);
        for (int num : array)
            System.out.print("\t" + num);
    }

    private static void shellSort(int[] array) {
        int N = array.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && array[j] < array[j - h]; j -= h) {
                    swap(array, j, j-h);
                }
            }
            h /= 3;
        }
    }

    private static void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

    }
}
