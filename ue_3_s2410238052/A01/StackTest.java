package ue_3_s2410238052.A01;

public class StackTest {

    public static void main(String[] args) {

        Stack s = new Stack();

        System.out.println("Leer? " + s.empty());

        s.push("A");
        s.push("B");
        s.push("C");

        System.out.println("Peek: " + s.peek());
        System.out.println("Pop: " + s.pop());
        System.out.println("Pop: " + s.pop());
        System.out.println("Peek: " + s.peek());
        System.out.println("Pop: " + s.pop());
        System.out.println("Leer? " + s.empty());
    }
}
