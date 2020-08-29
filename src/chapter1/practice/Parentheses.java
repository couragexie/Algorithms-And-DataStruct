package chapter1.practice;

import chapter1.dataStructure.Stack;

/**
 * @author xj138
 * 1.3.4 题括号匹配问题
 */
public class Parentheses {
    public static boolean matching(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c == ')' && stack.peek() != '(')
                    return false;
                else if (c == '}' && stack.peek() != '{')
                    return false;
                else if (c == ']' && stack.peek() != '[')
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "{[[[]]]}[]()({{{}}})[";
        System.out.println(matching(str));
    }

}

