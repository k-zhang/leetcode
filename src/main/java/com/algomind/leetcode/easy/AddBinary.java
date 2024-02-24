package com.algomind.leetcode.easy;

import java.math.BigInteger;

public class AddBinary {
    public String addBinary(String a, String b) {
        var ai = new BigInteger(a, 2);
        var bi = new BigInteger(b, 2);
        var result = ai.add(bi);
        return result.toString(2);
    }

    public String addBinary1(String a, String b) {
        int al = a.length();
        int bl = b.length();

        var sb = new StringBuilder();
        int ap = al - 1, bp = bl - 1;
        char carry = '0';
        while(ap >= 0 && bp >= 0) {
            var aCurrent = a.charAt(ap);
            var bCurrent = b.charAt(bp);
            
            if(aCurrent == '0' && bCurrent == '0' && carry == '0') {
                sb.insert(0, "0");
                carry = '0';
            }else if((aCurrent == '1' && bCurrent == '0' && carry == '0') ||
                     (aCurrent == '0' && bCurrent == '1' && carry == '0') ||
                     (aCurrent == '0' && bCurrent == '0' && carry == '1')) {
                sb.insert(0, '1');
                carry = '0';
            }else if (aCurrent == '1' && bCurrent == '1' && carry == '1') {
                sb.insert(0, '1');
                carry = '1';
            }else if((aCurrent == '1' && bCurrent == '1' && carry == '0') ||
                    (aCurrent == '1' && bCurrent == '0' && carry == '1') ||
                    (aCurrent == '0' && bCurrent == '1' && carry == '1')) {
                sb.insert(0, '0');
                carry = '1';
            }

            ap--;
            bp--;
        }

        if(ap >= 0) {
            carry = postProcessing(a, ap, carry, sb);
        }else{
            carry = postProcessing(b, bp, carry, sb);
        }

        if(carry == '1') {
            sb.insert(0, '1');
        }

        return sb.toString();
    }

    private char postProcessing(String str, int p, char carry, StringBuilder sb) {
        while(p >= 0) {
            var aCurrent = str.charAt(p);
            if(aCurrent == '0' && carry == '0') {
                sb.insert(0, '0');
            }else if((aCurrent == '1' && carry == '0') ||
                    (aCurrent == '0' && carry == '1')){
                sb.insert(0, '1');
                carry = '0';
            }else if(aCurrent == '1' && carry == '1') {
                sb.insert(0, '0');
                carry = '1';
            }
            p --;
        }
        return carry;
    }

    public String addBinary2(String a, String b) {
        int n = a.length(), m = b.length();
        if (n < m) return addBinary2(b, a);
        int L = Math.max(n, m);

        StringBuilder sb = new StringBuilder();
        int carry = 0, j = m - 1;
        for (int i = L - 1; i > -1; --i) {
            if (a.charAt(i) == '1') ++carry;
            if (j > -1 && b.charAt(j--) == '1') ++carry;

            if (carry % 2 == 1) sb.append('1');
            else sb.append('0');

            carry /= 2;
        }
        if (carry == 1) sb.append('1');
        sb.reverse();

        return sb.toString();
    }

    public String addBinary3(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, answer;
        while (y.compareTo(zero) != 0) {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
    }
}
