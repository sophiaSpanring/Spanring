package ue_2_s2410238052;

import lecture.chapter03.SList;
import lecture.chapter03.IKey;

public class MySList extends SList {

    public void append(Object data) {
        Node newNode = new Node(data, null);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public boolean insert(Object prev, Object data) {

        if (head == null) {
            return false;
        }

        Node current = head;
        while (current != null && current.data != prev) {
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        Node newNode = new Node(data, current.next);
        current.next = newNode;

        return true;
    }


    public SList searchAll(IKey key) {
        SList result = new SList();

        Node current = head;
        while (current != null) {
            if (key.matches(current.data)) {
                result.prepend(current.data);
            }
            current = current.next;
        }

        return result;
    }

}
