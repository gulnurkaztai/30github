package day43;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length < 3)
            return Integer.parseInt(tokens[0]);
        Deque<Integer> s = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("/") || tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*")) {
                int b = s.pop();
                int a = s.pop();
                if (tokens[i].equals("+")) {
                    s.push(a + b);
                } else if (tokens[i].equals("*")) {
                    s.push(a * b);
                } else if (tokens[i].equals("-")) {
                    s.push(a - b);
                } else if (tokens[i].equals("/")) {
                    s.push(a / b);
                }
            } else {
                s.push(Integer.parseInt(tokens[i]));
            }
        }
        return s.pop();
    }
}