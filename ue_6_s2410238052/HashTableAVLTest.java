package ue_6_s2410238052;

public class HashTableAVLTest {
    public static void main(String[] args) {

        System.out.println("HashTableAVL Test");

        HashTableAVL table = new HashTableAVL(2);

        table.insert("apple", 10);
        table.insert("banana", 20);
        table.insert("cherry", 30);
        table.insert("date", 40);

        System.out.println("Insert abgeschlossen");

        System.out.println("apple  -> " + table.get("apple"));
        System.out.println("banana -> " + table.get("banana"));
        System.out.println("cherry -> " + table.get("cherry"));
        System.out.println("date   -> " + table.get("date"));
        System.out.println("kiwi   -> " + table.get("kiwi"));

        table.remove("banana");
        System.out.println("banana nach remove -> " + table.get("banana"));

        table.insert("apple", 99);
        System.out.println("apple nach update -> " + table.get("apple"));
    }
}
