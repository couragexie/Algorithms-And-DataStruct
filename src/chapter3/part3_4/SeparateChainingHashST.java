package chapter3.part3_4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class SeparateChainingHashST<Key, Value> {
    private int N;  // 键值对数量
    private int M;    // 符号表的大小
    SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        this.M = M;
        // 创建泛型数组，由于Java不允许直接创建泛型数组。所以需要求其进行转换。
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST(); // 为数组中创建对象;
    }

    public int hash(Key key) {
        int hash = (key.hashCode() & 0x7fffffff) % M;
        System.out.println("hashCode of Key : " + key.hashCode() + " ,  hash 运算： " + (key.hashCode() & 0x7fffffff) + " , hash： " + hash);
        return hash;
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        st[hash(key)].put(key, value);
        N++;
    }

    public int size() {
        return N;
    }

    public void delete(Key key) {
        st[hash(key)].delete(key);
        N--;
    }

    public static void main(String[] args) {
        SeparateChainingHashST<Character, Integer> st = new SeparateChainingHashST<>(15);
        char[] c = {'S', 'B', 'C', 'D', 'E'};
        for (int i = 0; i < c.length; i++)
            st.put(c[i], i);
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());
        System.out.println(st.get('S'));
        st.delete('S');
        System.out.println(st.get('S'));
    }

}
