package ue_3_s2410238052.A02;

public class Queue {

    private MyDList list = new MyDList();

    public void enqueue(Object data) {
        list.append(data);
    }

    public Object dequeue() {
        return list.removeFirst();
    }

    public Object peek() {
        return list.getFirst();
    }

    public boolean empty() {
        return list.isEmpty();
    }
}
