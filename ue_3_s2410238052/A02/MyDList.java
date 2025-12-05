package ue_3_s2410238052.A02;

import lecture.chapter03.DList;

public class MyDList extends DList {

    public Object removeFirst() {
        if (head == null) {
            return null;
        }
        Object value = head.data;
        head = head.next;

        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        return value;
    }

    public Object getFirst() {
        return head != null ? head.data : null;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
