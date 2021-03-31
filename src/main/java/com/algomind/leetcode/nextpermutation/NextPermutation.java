package com.algomind.leetcode.nextpermutation;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1) return;

        boolean validSwap = false;
        int pl=-1;
        for(int i = nums.length - 2; i >= 0 ; i--) {
            int swapCandidate = Integer.MAX_VALUE;
            int pswap = -1;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i] && nums[j] < swapCandidate) {
                    swapCandidate = nums[j];
                    pswap = j;
                }
            }

            if(pswap != -1) {
                validSwap = true;
                int temp = nums[pswap];
                nums[pswap] = nums[i];
                nums[i] = temp;
                pl = i;
                break;
            }
        }

        if(!validSwap) {
            Arrays.sort(nums);
        }else{
            if(pl != -1 && pl < nums.length - 2) {
                Arrays.sort(nums,pl+1,nums.length);
            }
        }
    }

    public void nextPermutation1(int[] nums) {
        if(nums.length == 1) return;

        int pr = 0;
        for(int i = nums.length - 1, j = i - 1; j >= 0 ; i--, j--) {
            if (nums[j] < nums[i]) {
                int diff = nums[i] - nums[j];
                int ii = i;
                while(ii + 1 < nums.length && nums[ii+1] == nums[ii]) ii++;

                int swap = ii;
                for(int k = i + 1 ; k < nums.length ; k++ ){
                    int newDiff = nums[k] - nums[j];
                    if(newDiff < 0) break;
                    if(newDiff > 0 && newDiff < diff) {
                        int kk = k;
                        while(kk + 1 < nums.length && nums[kk+1] == nums[kk]) kk++;
                        swap = kk;
                        diff = newDiff;
                    }
                }

                int temp = nums[j];
                nums[j] = nums[swap];
                nums[swap] = temp;

                pr = i;
                while(pr + 1 < nums.length && nums[pr] < nums[pr+1]) pr++;

                break;
            }
        }

        int p1 = pr, p2 = nums.length - 1;
        while(p1 < p2) {
            int temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
            p1++;
            p2--;
        }
    }
}
