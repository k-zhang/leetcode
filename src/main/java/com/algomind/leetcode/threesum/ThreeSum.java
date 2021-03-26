package com.algomind.leetcode.threesum;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return List.of();
        Arrays.sort(nums);
        if(nums[0] > 0 || nums[nums.length-1] < 0) return List.of();

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < nums.length - 1 && nums[i] <= 0 ; i ++) {
            if(i == 0 || nums[i-1] != nums[i]) {
                twoSum(nums, i, res);
            }
        }
        return res;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> res) {
        Set<Integer> observed = new HashSet<>();
        for(int j = i+1 ; j < nums.length ; j++) {
            int complement = -(nums[i]) + (-nums[j]);
            if(observed.contains(complement)) {
                res.add(List.of(nums[i], nums[j], complement));
                while(j+1 < nums.length && nums[j + 1] == nums[j]) j++;
            }
            observed.add(nums[j]);
        }
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        if(nums.length < 3) return List.of();
        Arrays.sort(nums);
        if(nums[0] > 0 || nums[nums.length-1] < 0) return List.of();

        int[] negNums = Arrays.stream(nums).filter(i -> i < 0).toArray();
        int[] posNums = Arrays.stream(nums).filter(i -> i > 0).toArray();
        int zeroCount = nums.length - negNums.length - posNums.length;

        int negPrev = 1, posPrev = -1;

        List<List<Integer>> res = new ArrayList<>();
        for(int pn = 0 ; pn < negNums.length ; pn++) {
            if(negNums[pn] == negPrev) continue;
            for(int pp = 0 ; pp < posNums.length ; pp++) {
                if(posNums[pp] == posPrev) continue;
                int checkNumber = negNums[pn] + posNums[pp];
                if (checkNumber < 0) {
                    // Search pos
                    int pp1 = pp + 1;
                    while (pp1 < posNums.length && checkNumber + posNums[pp1] != 0) pp1++;
                    if (pp1 < posNums.length && checkNumber + posNums[pp1] == 0)
                        res.add(List.of(negNums[pn], posNums[pp], posNums[pp1]));
                } else if (checkNumber > 0) {
                    // Search neg
                    int pn1 = pn + 1;
                    while (pn1 < negNums.length && checkNumber + negNums[pn1] != 0) pn1++;
                    if (pn1 < negNums.length && checkNumber + negNums[pn1] == 0)
                        res.add(List.of(negNums[pn], negNums[pn1], posNums[pp]));
                } else {
                    if (zeroCount > 0) {
                        res.add(List.of(negNums[pn], 0, posNums[pp]));
                    }
                }

                posPrev = posNums[pp];
            }

            posPrev = -1;
            negPrev = negNums[pn];
        }

        if(zeroCount >= 3) res.add(List.of(0,0,0));

        return res;
    }
}
