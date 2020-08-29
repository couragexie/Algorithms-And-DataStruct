package chapter1.practice;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author xj138
 * ŷ������㷨
 */
public class FindGcd {
    public static int gcd(int p, int q) {
        if (q == 0)
            return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static int gcdN(int p, int q) {
        int r = p % q;
        while (r != 0) {
            p = q;
            q = r;
            r = p % q;
        }

        return q;
    }

    public static void main(String[] args) {
		
		/*
		int p = 1111111;
		int q = 1234567;
		StdOut.println(gcd(p,q));
		StdOut.println(gcdN(p,q));
		*/
        int p, q;
        p = StdIn.readInt();
        q = StdIn.readInt();
        StdOut.println(gcd(p, q));
        StdOut.println(gcdN(p, q));
    }

}
