package ue_3_s2410238052.A03_A04;

public class MyBTreeTest2 {

    public static void main(String[] args) {

        MyBTree tree = new MyBTree();

        // Baum füllen
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);

        System.out.println("Baum vor dem Löschen:");
        tree.printBreadthFirst();

        System.out.println("\nLösche 20...");
        tree.remove(20);

        System.out.println("Baum nach dem Löschen:");
        tree.printBreadthFirst();

        System.out.println("\nLösche 10 (Wurzel)...");
        tree.remove(10);

        System.out.println("Baum nach dem Löschen der Wurzel:");
        tree.printBreadthFirst();
    }
}
