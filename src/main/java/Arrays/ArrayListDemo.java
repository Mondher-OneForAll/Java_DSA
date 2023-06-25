package Arrays;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> foods = new ArrayList<String>();
        foods.add("Pizza");
        foods.add("Hamburg");
        foods.add("Pasta");
        foods.set(2,"Sushi");
        //foods.remove(1);
        //foods.clear();
        
        for (String food : foods) System.out.println(food);

        ArrayList<String> drinks = new ArrayList();
        drinks.add("Coka-cola");
        drinks.add("orange jus");
        drinks.add("Thee");
        drinks.add("Coffee");
        for (String drink : drinks) System.out.println(drink);

        System.out.println(foods);
        System.out.println(drinks);

        ArrayList<ArrayList<String>> grocery = new ArrayList();
        grocery.add(foods);
        grocery.add(drinks);
        System.out.println(grocery);
        System.out.println(grocery.get(1).get(2));

    }
}
