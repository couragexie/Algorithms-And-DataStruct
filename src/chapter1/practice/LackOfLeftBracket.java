package chapter1.practice;

import chapter1.dataStructure.Stack;
import edu.princeton.cs.algs4.StdOut;

public class LackOfLeftBracket {
    public static String addLeft(String str) {
        Stack<String> opr = new Stack<>();
        Stack<String> data = new Stack<>();
        String result;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                data.push((str.charAt(i)) + "");
            } else if (isOperate(str.charAt(i))) {
                opr.push(str.charAt(i) + "");
            } else {
                String num1 = data.pop();
                String num2 = data.pop();
                String oprate = opr.pop();
                String newNum = "(" + num2 + oprate + num1 + ")";
                data.push(newNum);
            }
        }
        return data.pop();
    }

    public static boolean isOperate(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/')
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        String str = "1+2)*3-4)*5-6)))";
        StdOut.println(addLeft(str));
    }
}
