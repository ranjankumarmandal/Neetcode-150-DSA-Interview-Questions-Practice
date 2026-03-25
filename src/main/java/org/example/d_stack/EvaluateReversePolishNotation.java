package org.example.d_stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++) {
            String t = tokens[i];

            if(t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;

                if(t.equals("+")) result = a + b;
                else if(t.equals("-")) result = a - b;
                else if(t.equals("*")) result = a * b;
                else result = a / b;

                stack.push(result);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }

        return stack.pop();
    }
}
