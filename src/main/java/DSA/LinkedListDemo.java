package DSA;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        /*
        linkedList.push("A");
        linkedList.push("B");
        linkedList.push("C");
        linkedList.push("D");
        linkedList.push("F");
        linkedList.pop();
         */

        linkedList.offer("A");
        linkedList.offer("B");
        linkedList.offer("C");
        linkedList.offer("D");
        linkedList.offer("F");
        linkedList.poll();

        linkedList.add(3, "E");
        linkedList.addFirst("A");
        linkedList.addLast("G");
        linkedList.removeFirst();
        linkedList.removeLast();
        
        System.out.println(linkedList);

    }
}
