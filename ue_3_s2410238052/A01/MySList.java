package ue_3_s2410238052.A01;

import lecture.chapter03.SList;

public class MySList extends SList {

    public Object removeFirst() {
        if (head == null) return null;
        Object value = head.data;
        head = head.next;
        return value;
    }

    public Object getFirst() {
        return head != null ? head.data : null;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
