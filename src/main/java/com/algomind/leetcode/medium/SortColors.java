package com.algomind.leetcode.medium;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        if(nums.length == 0) return;

        int[] counts = new int[3];
        for (int num : nums) counts[num]++;
        Arrays.fill(nums, 0, counts[0], 0);
        Arrays.fill(nums, counts[0], counts[0] + counts[1], 1);
        Arrays.fill(nums, counts[0] + counts[1], nums.length, 2);
    }

    // Dutch flag method
    public void sortColors1(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        int current = 0;

        while(current <= p2) {
            if(nums[current] == 0) {
                swap(nums, current, p0);
                p0 ++;
                current++;
            }else if(nums[current] == 2) {
                swap(nums, current, p2);
                p2 --;
            }else {
                current++;
            }
        }
    }

    private void swap(int[] nums, int current, int p0) {
        int temp = nums[current];
        nums[current] = nums[p0];
        nums[p0] = temp;
    }
}
