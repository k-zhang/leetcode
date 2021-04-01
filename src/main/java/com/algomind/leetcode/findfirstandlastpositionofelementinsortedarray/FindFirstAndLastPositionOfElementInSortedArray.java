package com.algomind.leetcode.findfirstandlastpositionofelementinsortedarray;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int searchResult = Arrays.binarySearch(nums, target);
        if(searchResult < 0) return new int[]{-1,-1};

        int pl = searchResult, pr = searchResult;
        while(pl-1 >= 0 && nums[pl-1] == target) pl --;
        while(pr+1 <= nums.length - 1 && nums[pr+1] == target) pr ++;

        return new int[]{pl,pr};
    }
}
