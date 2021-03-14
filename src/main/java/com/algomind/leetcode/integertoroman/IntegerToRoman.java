package com.algomind.leetcode.integertoroman;

public class IntegerToRoman {
    public String intToRoman(int num) {
        int remain;
        int countM = num / 1000; remain = num % 1000;
        int countC = remain / 100; remain = remain % 100;
        int countX = remain / 10; remain = remain % 10;
        int countI = remain;

        StringBuilder sb = new StringBuilder();

        // Translate M (1000)
        sb.append("M".repeat(countM));

        // Translate C (100)
        if(countC == 9) sb.append("CM");
        else if(countC == 4) sb.append("CD");
        else {
            if(countC < 5) sb.append("C".repeat(countC));
            else if(countC > 5) sb.append("D").append("C".repeat(countC - 5));
            else sb.append("D");
        }

        // Translate X (10)
        if(countX == 9) sb.append("XC");
        else if(countX == 4) sb.append("XL");
        else {
            if(countX < 5) sb.append("X".repeat(countX));
            else if(countX > 5) sb.append("L").append("X".repeat(countX - 5));
            else sb.append("L");
        }

        // Translate I (1)
        if(countI == 9) sb.append("IX");
        else if(countI == 4) sb.append("IV");
        else {
            if(countI < 5) sb.append("I".repeat(countI));
            else if(countI > 5) sb.append("V").append("I".repeat(countI - 5));
            else sb.append("V");
        }

        return sb.toString();
    }
}
