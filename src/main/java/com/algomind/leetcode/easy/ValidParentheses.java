package com.algomind.leetcode.easy;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        var stack = new Stack<Character>();
        for(int i = 0  ; i < s.length() ; i ++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
