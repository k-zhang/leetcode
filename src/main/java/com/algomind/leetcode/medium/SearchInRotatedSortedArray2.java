package com.algomind.leetcode.medium;

public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        int indexZero = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) indexZero = i;
        }

        boolean result = false;
        if(indexZero == 0) {
            result = binarySearch(nums, indexZero, nums.length - 1, target);
        }else{
            if(target >= nums[0] && target <= nums[indexZero - 1]) {
                if(target == nums[0] || target == nums[indexZero - 1]) return true;
                return binarySearch(nums, 0, indexZero - 1, target);
            }else if(target >= nums[indexZero] && target <= nums[nums.length - 1]){
                if(target == nums[indexZero] || target == nums[nums.length - 1]) return true;
                return binarySearch(nums, indexZero, nums.length - 1, target);
            }
        }

        return result;
    }

    private boolean binarySearch(int[] nums, int left, int right, int target) {
        while(left <= right) {
            int mid = (left + right) / 2;
            if(target == nums[mid]) {
                return true;
            }else if(target < nums[mid]) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return false;
    }
}
