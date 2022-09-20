package com.algomind.leetcode.medium;

import java.util.Arrays;

public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if(n < 3) return 0;

        Arrays.sort(nums);

        int result = 0;
        for(int i = 0 ; i < n - 2 ; i ++) {
            int k = i + 2;
            for(int j = i+1 ; j < n - 1 && nums[i] != 0; j ++) {
                while(k < n && nums[i] + nums[j] > nums[k]) k ++;
                result += k - j - 1;
            }
        }

        return result;
    }

    public int triangleNumber1(int[] nums) {
        int n = nums.length;
        if(n < 3) return 0;

        Arrays.sort(nums);

        int result = 0;
        for(int i = 0 ; i < n - 2 ; i ++) {
            int k = i + 2;
            for(int j = i + 1 ; j < n - 1 && nums[i] != 0; j ++) {
                k = binarySearch(nums, k, n, nums[i] + nums[j]);
                result += k - j - 1;
            }
        }

        return result;
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        while(l < r) {
            int mid = l + (r - l) / 2;

            if(nums[mid] < target) {
                l = mid + 1;
            }else{
                r = mid;
            }
        }

        return l;
    }

    public int triangleNumber2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;

        for (int i = n - 1; i >= 2; --i) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    res += r - l;
                    --r;
                } else {
                    ++l;
                }
            }
        }

        return res;
    }
}
