package com.algomind.leetcode.medium;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left <= right) {
            int mid = (right + left) / 2;
            if(nums[mid] == target) {
                return mid;
            }

            if(nums[left] < nums[mid]){
                if(nums[left] <= target && target <= nums[mid]) {
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else if(nums[right] > nums[mid]) {
                if(nums[mid] <= target && target <= nums[right]) {
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }else{
                if(nums[left] == target) return left;
                else if(nums[right] == target) return right;
                else break;
            }
        }

        return -1;
    }
}
