package ue_4_s2410238052;

public class HeapTest {

    public static void main(String[] args) {

        Heap heap = new Heap();

        System.out.println("Einfügen in den Min-Heap:");
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(7);
        heap.insert(2);

        System.out.println("\nAusgabe in Breadth-First Reihenfolge:");
        heap.printBreadthFirst();
    }
}
