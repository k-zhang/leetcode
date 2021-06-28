package com.algomind.leetcode.removealladjacentduplicatesinstring;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        if(s.length() == 1) return s;

        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i ++) {
            if(!stack.isEmpty() && stack.peek().equals(s.charAt(i))) {
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(var c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public String removeDuplicates2(String s) {
        if(s.length() == 1) return s;

        var sb = new StringBuilder();
        int length = 0;
        for(var character : s.toCharArray()) {
            if(length != 0 && sb.charAt(length - 1) == character) {
                sb.deleteCharAt(length - 1);
                length--;
            }else{
                sb.append(character);
                length ++;
            }
        }

        return sb.toString();
    }
}
