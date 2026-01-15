package ue_6_s2410238052;

import lecture.chapter03.*;

public class HashTableAVL {

    protected Bucket[] buckets;
    protected int size;
    protected int maxLoad;
    protected int currentLoad;

    protected static class Bucket {
        AVLTree tree = new AVLTree(new TupleComparator());
    }

    protected static class Tuple {
        public long hash;
        public String key;
        public Object data;

        public Tuple(long hash, String key, Object data) {
            this.hash = hash;
            this.key = key;
            this.data = data;
        }
    }

    protected static class TupleKey implements IKey {
        String key;

        public TupleKey(String key) {
            this.key = key;
        }

        public boolean matches(Object data) {
            return key.equals(((Tuple) data).key);
        }
    }

    protected static class TupleComparator implements IComparator {

        public int compare(Object o1, Object o2) {
            return ((Tuple) o1).key.compareTo(((Tuple) o2).key);
        }

        public int compare(Object data, IKey key) {
            return ((Tuple) data).key.compareTo(((TupleKey) key).key);
        }
    }

    private static long sdbm(String s) {
        long hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = s.charAt(i) + (hash << 6) + (hash << 16) - hash;
        }
        return hash;
    }

    public HashTableAVL(int exponent) {
        size = 1 << exponent;
        maxLoad = (int) (size * 0.75);
        buckets = new Bucket[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new Bucket();
        }
    }

    public void insert(String key, Object data) {
        long hash = sdbm(key);
        int index = (int) (hash & (size - 1));
        buckets[index].tree.insert(new Tuple(hash, key, data));
        currentLoad++;
    }

    public Object get(String key) {
        long hash = sdbm(key);
        int index = (int) (hash & (size - 1));
        Tuple t = (Tuple) buckets[index].tree.search(new TupleKey(key));
        return t != null ? t.data : null;
    }

    public void remove(String key) {
        long hash = sdbm(key);
        int index = (int) (hash & (size - 1));
        Tuple t = (Tuple) buckets[index].tree.search(new TupleKey(key));
        if (t != null) {
            buckets[index].tree.remove(t);
        }
    }
}
