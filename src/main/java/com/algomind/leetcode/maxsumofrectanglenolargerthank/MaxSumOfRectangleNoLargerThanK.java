package com.algomind.leetcode.maxsumofrectanglenolargerthank;

import java.util.Arrays;
import java.util.TreeSet;

public class MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix[0].length;
        int n = matrix.length;

        int[] sumPrefix = new int[n];

        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < m ; i ++) {
            Arrays.fill(sumPrefix, 0);
            for(int j = i ; j < m ; j ++) {
                for(int t = 0 ; t < n ; t ++) {
                    sumPrefix[t] += matrix[t][j];
                }

                max = Math.max(max, dpMax(sumPrefix, k));
            }
        }

        return max;
    }

    private int dpMax(int[] nums, int k) {
        int sum = 0;
        int result = 0;

        // Container to store sorted prefix sums.
        TreeSet<Integer> sortedSum = new TreeSet<>();

        // Add 0 as the prefix sum for an empty sub-array.
        sortedSum.add(0);
        for (int num : nums) {
            // Running Sum.
            sum += num;

            // Get X where Running sum - X <= k such that sum - X is closest to k.
            Integer x = sortedSum.ceiling(sum - k);

            // If such X is found in the prefix sums.
            // Get the sum of that sub array and update the global maximum result.
            if (x != null)
                result = Math.max(result, sum - x);

            // Insert the current running sum to the prefix sums container.
            sortedSum.add(sum);
        }

        return result;
    }
}
