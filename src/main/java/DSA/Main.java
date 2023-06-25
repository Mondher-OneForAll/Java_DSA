package DSA;

public class Main {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray(5);


        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C");

        System.out.println("Empty: " + dynamicArray.isEmpty());
        System.out.println("Size: " + dynamicArray.size);
        System.out.println("Capacity: " + dynamicArray.capacity);
        String data = "C";
        System.out.println(data + " is at index : " + dynamicArray.search(data));
        System.out.println(dynamicArray);
        dynamicArray.insert(0, "X");
        System.out.println(dynamicArray);
        System.out.println("Size: " + dynamicArray.size);
        dynamicArray.delete("A");
        dynamicArray.add("A");
        dynamicArray.add("E");
        dynamicArray.add("F");
        System.out.println(dynamicArray);
        System.out.println("Size: " + dynamicArray.size);
        dynamicArray.delete("C");
        dynamicArray.delete("B");
        dynamicArray.delete("E");
        System.out.println(dynamicArray);
        System.out.println("Size: " + dynamicArray.size);



    }
}
