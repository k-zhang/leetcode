package com.algomind.leetcode.removeduplicatesfromsortedarray2;

public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int repeatValue = Integer.MIN_VALUE;
        for(int i = 2 ; i < nums.length; i++) {
            if(nums[i] == repeatValue || (nums[i] == nums[i - 1] && nums[i] == nums[i - 2])) {
                repeatValue = nums[i];
                nums[i] = Integer.MAX_VALUE;
            }
        }

        int p = 3;
        for(int i = 2 ; i < nums.length; i++) {
            if(nums[i] == Integer.MAX_VALUE) {
                if(p < i) p = i;
                while(p < nums.length && nums[p] == Integer.MAX_VALUE) p++;
                if( p == nums.length) return i;
                swap(nums, i, p);
                p++;
            }
        }

        return nums.length;
    }

    private void swap(int[] nums, int i, int p) {
        int temp = nums[i];
        nums[i] = nums[p];
        nums[p] = temp;
    }

    public int removeDuplicates1(int[] nums) {
        int j = 1;
        int count = 1;

        for(int i = 1 ; i < nums.length ; i++) {
            if(nums[i] == nums[i-1]) count++;
            else count = 1;

            if(count <= 2) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }
}
