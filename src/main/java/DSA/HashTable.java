package DSA;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTable {
    public static void main(String[] args) {

        Hashtable<String, String> table = new Hashtable<>(11);

        table.put("100", "Tanjiro");
        table.put("717", "Uzui");
        table.put("123", "Yuichiro");
        table.put("121", "Tokito");
        table.put("555", "Inoskue");
        table.put("321", "Zenitsu");


        for (String key : table.keySet())
            System.out.println(key.hashCode() % 11  + "\t\t" + key + "\t\t" + table.get(key));

        System.out.println(table.containsKey("121"));
        System.out.println(table.containsValue("Tokito"));

        String s = "Hello";
        char c  = 'H';

        System.out.println(s.length());


    }
}
