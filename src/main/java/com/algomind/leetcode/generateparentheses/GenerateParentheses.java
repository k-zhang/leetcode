package com.algomind.leetcode.generateparentheses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        var string = new char[n * 2];
        for(var i = 0 ; i < n; i++) string[i] = '(';
        for(var i = n ; i < 2 * n; i++) string[i] = ')';

        var result = new ArrayList<String>();
        result.add(new String(string));

        find(string, n, n, 1, result);
        return result;
    }

    private void find(char[] string, int n, int currentCloseIndex, int closeNumber, List<String> result) {
        if(closeNumber == n) return;

        var openCountToLeft = n;
        var nextCloseIndex = currentCloseIndex + 1;
        for(int i = 0 ; i < n - closeNumber ; i++ ) {
            if(openCountToLeft - 1 >= closeNumber && string[currentCloseIndex - 1] != ')') {
                swap(string, currentCloseIndex, currentCloseIndex - 1);
                result.add(new String(string));
                currentCloseIndex  = currentCloseIndex - 1;
                openCountToLeft --;
                find(Arrays.copyOf(string, string.length), n, nextCloseIndex, closeNumber + 1, result );
            }
        }
    }

    private void swap(char[] string, int c1, int c2) {
        char temp = string[c2];
        string[c2] = string[c1];
        string[c1] = temp;
    }

    // Slow but clever
    public List<String> generateParenthesis1(int n) {
        var ans = new ArrayList<String>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; c++) {
                for (String left : generateParenthesis(c)) {
                    for (String right : generateParenthesis(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return ans;
    }
}
