package DSA;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayList_VS_LinkedList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 1000000; i++){
            arrayList.add(i);
            linkedList.add(i);
        }

        long startTime;
        long endTime;
        long elapsedTime;

        startTime = System.nanoTime();
        //arrayList.get(500000);
        //arrayList.remove(500000);
        arrayList.indexOf(999999);
        endTime = System.nanoTime();

        elapsedTime = endTime - startTime;
        System.out.println("Arraylist : \t" + elapsedTime + " ns");


        startTime = System.nanoTime();
        //linkedList.get(500000);
        //linkedList.remove(500000);
        linkedList.indexOf(999999);
        endTime = System.nanoTime();

        elapsedTime = endTime - startTime;
        System.out.println("Linkedlist : \t" + elapsedTime + " ns");


    }
}
