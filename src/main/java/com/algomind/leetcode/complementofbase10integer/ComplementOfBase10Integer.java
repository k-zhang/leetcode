package com.algomind.leetcode.complementofbase10integer;

public class ComplementOfBase10Integer {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;

        var bit = 1;
        var old = n;
        while((n & old) != 0) {
            n = n ^ bit;
            bit = bit << 1;
        }
        return n;
    }
}
