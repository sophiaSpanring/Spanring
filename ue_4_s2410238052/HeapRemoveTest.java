package ue_4_s2410238052;

public class HeapRemoveTest {

    public static void main(String[] args) {
        Heap h = new Heap();

        h.insert(5);
        h.insert(3);
        h.insert(8);
        h.insert(1);
        h.insert(7);
        h.insert(2);

        System.out.println("Heap vor remove(3):");
        h.printBreadthFirst();

        h.remove(3);

        System.out.println("\nHeap nach remove(3):");
        h.printBreadthFirst();
    }
}

