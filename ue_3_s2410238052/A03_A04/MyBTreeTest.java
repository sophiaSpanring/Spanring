package ue_3_s2410238052.A03_A04;

public class MyBTreeTest {

    public static void main(String[] args) {

        MyBTree tree = new MyBTree();

        tree.insert("A");
        tree.insert("B");
        tree.insert("C");
        tree.insert("D");
        tree.insert("E");

        tree.printBreadthFirst();
    }
}
