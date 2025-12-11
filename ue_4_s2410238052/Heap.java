package ue_4_s2410238052;

import ue_3_s2410238052.A03_A04.MyBTree;

import lecture.chapter03.IKey;
import ue_3_s2410238052.A02.Queue;

public class Heap extends MyBTree {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected void upHeap(Node leaf) {
        if (leaf == null) {
            return;
        }

        Node current = leaf;

        while (current.parent != null) {
            Object currentData = current.data;
            Object parentData = current.parent.data;

            Comparable cCur = (Comparable) currentData;
            Comparable cPar = (Comparable) parentData;

            if (cCur.compareTo(cPar) < 0) {
                Object tmp = current.data;
                current.data = current.parent.data;
                current.parent.data = tmp;

                current = current.parent;
            } else {
                break;
            }
        }
    }

    @Override
    public void insert(Object data) {
        Node newNode = new Node(null, data, null);

        breadthFirstAppend(newNode);

        upHeap(newNode);
    }

    // Aufgabe 2:

    protected Node heapSearch(Node current, IKey key) {
        if (current == null) return null;

        Queue q = new Queue();
        q.enqueue(current);

        while (!q.empty()) {
            Node n = (Node) q.dequeue();

            if (key.matches(n.data)) {
                return n;
            }

            if (n.left != null) q.enqueue(n.left);
            if (n.right != null) q.enqueue(n.right);
        }
        return null;
    }

    public Object heapSearch(IKey key) {
        Node found = heapSearch(root, key);
        return found != null ? found.data : null;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected void downHeap(Node node) {
        if (node == null) return;

        Node current = node;

        while (true) {
            Node left = current.left;
            Node right = current.right;

            if (left == null && right == null) break;

            Node smallerChild = null;

            if (left != null && right != null) {
                Comparable l = (Comparable) left.data;
                Comparable r = (Comparable) right.data;
                smallerChild = (l.compareTo(r) < 0) ? left : right;
            }
            else if (left != null) {
                smallerChild = left;
            }
            else {
                smallerChild = right;
            }

            Comparable cur = (Comparable) current.data;
            Comparable child = (Comparable) smallerChild.data;

            if (cur.compareTo(child) <= 0) break;

            Object tmp = current.data;
            current.data = smallerChild.data;
            smallerChild.data = tmp;
            current = smallerChild;
        }
    }

    public void remove(Object data) {
        if (root == null) return;

        Node node = heapSearch(root, obj -> obj.equals(data));
        if (node == null) return;

        Node last = getLastNode();

        if (last == root) {
            root = null;
            return;
        }

        node.data = last.data;

        Node p = last.parent;
        if (p.left == last) p.left = null;
        else p.right = null;

        downHeap(node);
    }

    //Aufgabe 3:

    private void embed(Node current, Object[] array, int index) {
        if (current == null) return;

        array[index] = current.data;

        if (current.left != null) {
            embed(current.left, array, 2 * index + 1);
        }
        if (current.right != null) {
            embed(current.right, array, 2 * index + 2);
        }
    }

    private static class Counter {
        int count = 0;
    }


    public Object[] toArray() {
        Counter c = new Counter();
        this.breadthFirst(data -> c.count++);

        Object[] array = new Object[c.count];

        embed(root, array, 0);

        return array;
    }
}