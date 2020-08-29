package chapter2.part2_4;

public class MaxHeap<E extends Comparable<E>> {
    private E[] data;        // data[0] 不使用，方便计算
    private int size;

    public MaxHeap(int n) {
        //不能使用  data  = (E[])new Object[capacity];
        // 因为 E 是继承来着 Comparable 接口 的类
        data = (E[]) new Comparable[n + 1];
        size = 0;
    }

    public MaxHeap() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        if (size == data.length - 1)
            resize((data.length - 1) * 2 + 1);
        data[++size] = e; // size + 1
        swim(size);
    }

    public boolean less(int v, int w) {
        return data[v].compareTo(data[w]) < 0;
    }

    public void exch(int v, int w) {
        E t = data[v];
        data[v] = data[w];
        data[w] = t;
    }

    // 元素上浮操作
    public void swim(int index) {
        while (index > 1 && less(index / 2, index)) {
            exch(index / 2, index);
            index = index / 2;
        }
    }

    // 删除并返回最大元素
    public E delMax() {
        E max = data[1];
        exch(1, size);
        data[size--] = null;  // size - 1;
        sink(1);

        if (size <= data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return max;
    }

    // 元素下沉操作
    public void sink(int index) {
        while (2 * index <= size) {
            int j = 2 * index; // 左子树的索引
            if (j < size && less(j, j + 1))  // 判断是否存在右子树且右子树比左子树大
                j++;
            if (!less(index, j))
                break;
            exch(index, j);
            index = j;
        }
    }

    public void resize(int capacity) {
        E[] temp = (E[]) new Comparable[capacity];
        for (int i = 1; i <= size; i++)
            temp[i] = data[i];
        data = temp;
    }
}
