package DSA;

public class DynamicArray {
    int size;
    int capacity = 10;
    Object[] array;

    public DynamicArray(){
        this.array = new Object[capacity];
    }
    public DynamicArray(int capacity){
        this.capacity = capacity;
        this.array = new Object[capacity];
    }
    public void add(Object data){
        if (size >= capacity) grow();
        array[size] = data;
        size++;
    }

    private void grow(){
        int newCapacity = (int) (capacity * 2);
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) newArray[i] = array[i];

        this.capacity = newCapacity;
        this.array = newArray;

    }

    public void delete(Object data){
        int index = search(data);
        if (index != -1){
            for (int i = index; i < size; i++){
                array[i] = array[i + 1];
            }
            size--;
            if (size <= (int) capacity/3) shrink();

        }else System.out.println("Not found, can't delete!!");


    }

    private void shrink(){
        int newCapacity = (int) (capacity / 2);
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) newArray[i] = array[i];

        this.capacity = newCapacity;
        this.array = newArray;

    }

    public void insert(int index, Object data){
        if (size >= capacity) grow();
        for (int i = size; i >= index; i--){
            array[i + 1] = array[i];
        }
        array[index] = data;
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int search(Object data){
        for (int i = 0; i < size; i++){
            if (data == array[i]){
                return i;
            }
        }
        return -1;
    }

    public String toString(){
        String string = "";
        for (int i = 0; i < array.length; i++) {
            string += array[i] + ",";
        }
        if (size != 0){
            string = "[" + string.substring(0, string.length() - 1) + "]";
        }else string = "[]";

        return string;
    }

}
