package ue_5_s2410238052;

public class PriorityQueueTest {
    public static void main(String[] args) {

        PriorityQueue pq = new PriorityQueue();

        pq.insert("A", 5);
        pq.insert("B", 2);
        pq.insert("C", 4);
        pq.insert("D", 2);
        pq.insert("E", 1);

        System.out.println(pq.extractMin()); // E
        System.out.println(pq.extractMin()); // B
        System.out.println(pq.extractMin()); // D
        System.out.println(pq.extractMin()); // C
        System.out.println(pq.extractMin()); // A
        System.out.println(pq.extractMin()); // null
    }
}
