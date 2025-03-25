package day42;

import java.util.Stack;

public class Solution2 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(' || ch[i] == '{' | ch[i] == '[') {
                stack.push(ch[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character c = stack.peek();
                if (c == '(' && ch[i] == ')' || c == '{' && ch[i] == '}' || c == '[' && ch[i] == ']') {
                    stack.pop();
                } else {
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }
}
