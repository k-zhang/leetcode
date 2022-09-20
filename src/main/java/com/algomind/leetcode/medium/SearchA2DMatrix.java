package com.algomind.leetcode.medium;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int length = m * n;

        int start = 0, end = length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            int valueAtMid = matrix[mid/n][mid%n];
            if(target == valueAtMid) {
                return true;
            }else if(target < valueAtMid) {
                end = mid - 1;
            }else if (target > valueAtMid){
                start = mid + 1;
            }
        }

        return false;
    }
}
