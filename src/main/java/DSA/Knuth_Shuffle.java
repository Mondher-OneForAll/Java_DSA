package DSA;

import java.util.Random;

public class Knuth_Shuffle {
    public static void main(String[] args) {

        int[] array = new int[30];
        for (int i = 0; i < 30; i++) {
            array[i] = i + 1;
        }
        shuffle(array);
        for (int num : array) System.out.print("\t" + num);

    }
    private static void shuffle(int[] array){
        Random random = new Random();
        int N = array.length;
        for (int i = 0; i < N; i++) {
            int r = random.nextInt(i + 1);
            swap(array, i, r);
        }
    }

    private static void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

    }

}
