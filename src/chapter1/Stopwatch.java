package chapter1;

/**
 * @author xj138
 * 计时器类，能够得到自该对象创建以来的时间
 */
public class Stopwatch {
    private final long start;

    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
