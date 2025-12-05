package ue_3_s2410238052.A02;

public class QueueTest {

    public static void main(String[] args) {

        Queue q = new Queue();

        System.out.println("Leer? " + q.empty());

        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");

        System.out.println("Peek: " + q.peek());
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Dequeue: " + q.dequeue());

        System.out.println("Peek: " + q.peek());
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Leer? " + q.empty());
    }
}
