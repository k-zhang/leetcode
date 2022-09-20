package com.algomind.leetcode.easy;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(target < nums[0]) return 0;
        if(target > nums[nums.length-1]) return nums.length;

        int left = 0, right = nums.length - 1;
        int result = 0;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                result = mid;
                break;
            }
        }

        if (target < nums[left]) {
            result = left;
        } else if (target > nums[right]) {
            result = right;
        }

        return result;
    }
}
