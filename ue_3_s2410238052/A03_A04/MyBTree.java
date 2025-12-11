package ue_3_s2410238052.A03_A04;

import lecture.chapter03.BTree;
import ue_3_s2410238052.A02.Queue;

public class MyBTree extends BTree {

    protected void breadthFirstAppend(Node newNode) {

        if (root == null) {
            root = newNode;
            return;
        }

        int h = height(root);

        for (int level = 0; level < h; level++) {
            if (insertAtLevel(root, newNode, level)) {
                return;
            }
        }
    }

    private boolean insertAtLevel(Node current, Node newNode, int level) {

        if (current == null) return false;

        if (level == 0) {

            if (current.left == null) {
                current.left = newNode;
                newNode.parent = current;
                return true;
            }
            if (current.right == null) {
                current.right = newNode;
                newNode.parent = current;
                return true;
            }

            return false;
        }
        return insertAtLevel(current.left, newNode, level - 1) ||
            insertAtLevel(current.right, newNode, level - 1);
    }

    public void insert(Object data) {
        Node newNode = new Node(null, data, null);
        breadthFirstAppend(newNode);
    }

    public void printBreadthFirst() {
        Queue q = new Queue();

        if (root != null) {
            q.enqueue(root);
        }

        while (!q.empty()) {
            Node current = (Node) q.dequeue();
            System.out.println(current.data);

            if (current.left != null) {
                q.enqueue(current.left);
            }
            if (current.right != null) {
                q.enqueue(current.right);
            }
        }
    }

    // Aufgabe 4:
    
    protected Node getLastNode() {
        Queue q = new Queue();
        q.enqueue(root);

        Node last = null;

        while (!q.empty()) {
            last = (Node) q.dequeue();
            if (last.left != null) q.enqueue(last.left);
            if (last.right != null) q.enqueue(last.right);
        }
        return last;
    }

    protected void remove(Node node) {
        if (node == null || root == null)
            return;

        Node last = getLastNode();

        if (last == root) {
            root = null;
            return;
        }

        node.data = last.data;

        Node p = last.parent;
        if (p.left == last) p.left = null;
        else p.right = null;
    }

    public void remove(Object data) {
        Node n = depthFirstSearch(root, obj -> obj.equals(data));
        remove(n);
    }


    // folgender Code relevant für eine andere Aufgabe:
    @Override
    public void breadthFirst(lecture.chapter03.IWorker worker) {
        Queue queue = new Queue();

        if (root != null) {
            queue.enqueue(root);
        }

        while (!queue.empty()) {
            Node current = (Node) queue.dequeue();
            worker.work(current.data);

            if (current.left != null) queue.enqueue(current.left);
            if (current.right != null) queue.enqueue(current.right);
        }
    }

}
