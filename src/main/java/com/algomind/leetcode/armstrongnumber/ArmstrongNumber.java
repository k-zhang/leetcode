package com.algomind.leetcode.armstrongnumber;

public class ArmstrongNumber {
    public boolean isArmstrong(int n) {
        String str = String.valueOf(n);

        int power = str.length();

        int sum = 0;
        for(int i = 0 ; i < power ; i ++) {
            sum += Math.pow(Integer.parseInt(str, i, i+1, 10), power);
        }

        return sum == n;
    }
}
