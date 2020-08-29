package chapter3.part3_4;

public class LinearProbingHashST<Key, Value> {
    private int N;
    private int M;
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashST() {
        this(16);
    }

    public LinearProbingHashST(int M) {
        this.M = M;
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
        N = 0;
    }

    public int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i++) {
            if (keys[i].equals(key))
                return values[i];
        }
        return null;
    }

    public void put(Key key, Value value) {
        int i = hash(key);
        while (keys[i] != null)
            i = (i + 1) % M;
        keys[i] = key;
        values[i] = value;
        ++N;

        if (N > 0 && N >= M / 2)
            resize(2 * M);
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void delete(Key key) {
        if (!contains(key)) return;

        int i = hash(key);
        while (!keys[i].equals(key))
            i = (i + 1) % M;
        keys[i] = null;
        values[i] = null;

        i = (i + 1) % M;
        while (keys[i] != null) {
            Key tkey = keys[i];
            Value tvalue = values[i];
            keys[i] = null;
            values = null;
            --N;
            put(tkey, tvalue);
            i = (i + 1) % M;
        }
        --N;
        if (N > 0 && N < M / 8)
            resize(M / 2);
    }

    private void resize(int capacity) {
        LinearProbingHashST<Key, Value> t = new LinearProbingHashST<>(capacity);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null)
                t.put(keys[i], values[i]);
        }
        keys = t.keys;
        values = t.values;
        M = t.M;
    }

    // 为什么可以这么定义
    public static void main(String[] args) {
        SeparateChainingHashST<Character, Integer> st = new SeparateChainingHashST<>(21);
        char[] c = {'S', 'B', 'C', 'D', 'E'};
        for (int i = 0; i < c.length; i++)
            st.put(c[i], i);

        System.out.println(st.get('S'));
        st.delete('S');
        System.out.println(st.get('S'));
    }

}
