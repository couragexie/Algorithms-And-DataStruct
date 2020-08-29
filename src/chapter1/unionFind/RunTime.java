package chapter1.unionFind;

import edu.princeton.cs.algs4.Date;

public class RunTime {
    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public void end() {
        endTime = System.nanoTime();
    }

    public double time() {
        return (endTime - startTime) / 1000000000.0;
    }
}
