package ue_3_s2410238052.A01;

public class Stack {

    private MySList list = new MySList();

    public void push(Object data) {
        list.prepend(data);
    }

    public Object pop() {
        return list.removeFirst();
    }

    public Object peek() {
        return list.getFirst();
    }

    public boolean empty() {
        return list.isEmpty();
    }
}
