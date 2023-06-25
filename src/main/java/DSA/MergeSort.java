package DSA;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {9,5,7,3,2,4,6,1,8};

        mergeSort(array);
        for (int i : array) System.out.print("\t" + i);
    }

    private static void mergeSort(int[] array) {
        int length = array.length;
        if(length <= 1) return;

        int middle = length/2;
        int[] lefArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0;//left
        int j = 0;//right

        for (; i < length; i++){
            if (i < middle) lefArray[i] = array[i];
            else{
                rightArray[j] = array[i];
                j++;
            }
        }

        mergeSort(lefArray);
        mergeSort(rightArray);
        merge(lefArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) {

        int leftSize = array.length/2;
        int rightSize = array.length - leftSize;
        int r = 0, l = 0, i = 0;
        while (l < leftSize && r < rightSize){
            if (leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else{
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while (l < leftSize){
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightSize){
            array[i] = rightArray[r];
            i++;
            r++;
        }

    }
}
