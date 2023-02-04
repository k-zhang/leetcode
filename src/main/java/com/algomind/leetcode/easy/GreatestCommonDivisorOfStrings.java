package com.algomind.leetcode.easy;

import java.util.Stack;

public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        var candidates = new Stack<Tuple>();

        if(str1.length() < str2.length()) {
            var temp = str1;
            str1 = str2;
            str2 = temp;
        }

        for(int i = 0 ; i < str1.length(); i++) {
            if(str2.length() > i && str1.charAt(i) == str2.charAt(i)) {
                candidates.push(new Tuple(str2.substring(0, i + 1), i + 1));
            }else if(str2.length() > i){
                break;
            }
        }

        while(!candidates.isEmpty()) {
            var gcd = candidates.pop();

            var leftOverIndex = gcd.getRight();
            var gcdLength = gcd.getLeft().length();

            if((str1.length() - leftOverIndex) % gcdLength != 0 || (str2.length() - leftOverIndex) % gcdLength != 0) {
                continue;
            }

            if(checkPattern(str1, gcd.getLeft(), leftOverIndex, gcdLength) && checkPattern(str2, gcd.getLeft(), leftOverIndex, gcdLength)) {
                return gcd.getLeft();
            }
        }

        return "";
    }

    private boolean checkPattern(String str, String gcd, int startIndex, int length) {
        while(true) {
            if(startIndex == str.length()) {
                return true;
            }

            var slice = str.substring(startIndex, startIndex + length);
            if(slice.equals(gcd)) {
                startIndex = startIndex + length;
            }else{
                return false;
            }
        }
    }

    private static class Tuple {
        private final String left;
        private final int right;

        public Tuple(String left, int right) {
            this.left = left;
            this.right = right;
        }

        public String getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }
    }

    //////////////

    public boolean valid(String str1, String str2, int k) {
        int len1 = str1.length(), len2 = str2.length();
        if (len1 % k > 0 || len2 % k > 0) {
            return false;
        } else {
            String base = str1.substring(0, k);
            return str1.replace(base, "").isEmpty() && str2.replace(base, "").isEmpty();
        }
    }


    public String gcdOfStrings2(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        for (int i = Math.min(len1, len2); i >= 1; --i) {
            if (valid(str1, str2, i)) {
                return str1.substring(0, i);
            }
        }
        return "";
    }
}
