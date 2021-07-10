package com.algomind.contest.question1;

public class CountSquareSumTriples {
    public int countTriples(int n) {
        int count = 0;
        for(int a = 1 ; a < n ; a ++) {
            for(int b = n ; b > 0; b --) {
                double root = Math.sqrt(a * a + b * b);
                int intRoot = (int) root;
                if (intRoot - root == 0 && intRoot <= n) {
                    count++;
                }
            }
        }

        return count;
    }
}
