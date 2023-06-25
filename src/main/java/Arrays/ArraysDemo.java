package Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        String[] cars = {"Camaro", "Corvette", "Tesla"};
        String[] animals = new String[3];

        animals[0] = "Dog";
        animals[1] = "Snake";
        animals[2] = "Cat";


        for (int i = 0; i < cars.length; i++){
            System.out.println(cars[i]);
            System.out.println(animals[i]);
        }

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8 ,9}, {1, 2, 3}};
        for (int[] rows : matrix) {
            for (int column : rows) {
                System.out.print(column +" ");
            }
            System.out.println();
        }
    }
}
