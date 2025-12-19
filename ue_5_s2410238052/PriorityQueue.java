package ue_5_s2410238052;

import ue_3_s2410238052.A02.MyDList;

public class PriorityQueue {

    private MyDList list;

    public PriorityQueue() {
        list = new MyDList();
    }

    public void insert(Object data, int priority) {
        list.append(new Entry(data, priority));
    }

    public Object extractMin() {

        if (list.isEmpty()) {
            return null;
        }

        Entry first = (Entry) list.getFirst();
        Entry min = first;

        do {
            Entry current = (Entry) list.removeFirst();

            if (current.priority < min.priority) {
                min = current;
            }

            list.append(current);

        } while (list.getFirst() != first);

        while (true) {
            Entry current = (Entry) list.removeFirst();
            if (current == min) {
                break;
            }
            list.append(current);
        }

        return min.data;
    }
}
