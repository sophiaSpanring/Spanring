package ue_6_s2410238052;

public class HashTableLinear {

    protected Tuple[] table;
    protected int size;
    protected int currentLoad;

    protected static final Tuple DELETED = new Tuple(-1, null, null);

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

    private static long sdbm(String s) {
        long hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = s.charAt(i) + (hash << 6) + (hash << 16) - hash;
        }
        return hash;
    }

    public HashTableLinear(int exponent) {
        size = 1 << exponent;
        table = new Tuple[size];
        currentLoad = 0;
    }

    public void insert(String key, Object data) {
        long hash = sdbm(key);
        int index = (int) (hash & (size - 1));

        while (table[index] != null && table[index] != DELETED) {
            if (table[index].key.equals(key)) {
                table[index].data = data;
                return;
            }
            index = (index + 1) & (size - 1);
        }

        table[index] = new Tuple(hash, key, data);
        currentLoad++;
    }

    public Object get(String key) {
        long hash = sdbm(key);
        int index = (int) (hash & (size - 1));

        while (table[index] != null) {
            if (table[index] != DELETED && table[index].key.equals(key)) {
                return table[index].data;
            }
            index = (index + 1) & (size - 1);
        }
        return null;
    }

    public void remove(String key) {
        long hash = sdbm(key);
        int index = (int) (hash & (size - 1));

        while (table[index] != null) {
            if (table[index] != DELETED && table[index].key.equals(key)) {
                table[index] = DELETED;
                currentLoad--;
                return;
            }
            index = (index + 1) & (size - 1);
        }
    }
}
