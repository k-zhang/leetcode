package com.algomind.leetcode.findpeakelement;

// Binary Search
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid = -1;

        while(left <= right) {
            mid = calculateMid(left, right, nums);
            boolean greaterThanLeft = mid - 1 < 0 || (nums[mid] > nums[mid - 1]);
            boolean greaterThanRight = mid + 1 >= nums.length || (nums[mid] > nums[mid + 1]);

            if(greaterThanLeft && greaterThanRight) {
                break;
            }

            if(nums[mid] < nums[mid-1]) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return mid;
    }

    private int calculateMid(int left, int right, int[] nums) {
        int mid;
        if(right - 1 == left) {
            mid = nums[left] > nums[right] ? left : right;
        }else{
            mid = (left + right) / 2;
        }
        return mid;
    }

    public int findPeakElement1(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
