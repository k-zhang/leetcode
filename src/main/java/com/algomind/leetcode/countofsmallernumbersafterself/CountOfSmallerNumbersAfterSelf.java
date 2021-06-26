package com.algomind.leetcode.countofsmallernumbersafterself;

import java.util.*;

public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        var bucketIndexMap = discrete(nums);
        BinaryIndexTree bit = new BinaryIndexTree(bucketIndexMap.size() + 1);

        var result = new ArrayList<Integer>();
        for(int i = nums.length - 1 ; i >= 0 ; i --) {
            int idx = bucketIndexMap.get(nums[i]);
            result.add(bit.query( idx - 1));
            bit.update(idx);
        }
        Collections.reverse(result);

        return result;
    }

    private Map<Integer, Integer> discrete(int[] nums) {
        var treeSet = new TreeSet<Integer>();
        Arrays.stream(nums).forEach(treeSet::add);
        var bitIndexMap = new HashMap<Integer, Integer>();
        Iterator<Integer> itr = treeSet.iterator();
        for(int i = 1 ; i <= treeSet.size() ; i ++) {
            bitIndexMap.put(itr.next(), i);
        }
        return bitIndexMap;
    }

    private static class BinaryIndexTree {
        private final int[] array;

        public BinaryIndexTree(int size) {
            array = new int[size];
        }

        private int lowBit(int x) {
            return x & (-x);
        }

        private void update(int index) {
            for(int i = index ; i < array.length; i += lowBit(i)) {
                array[i] += 1;
            }
        }

        private int query(int index) {
            int result = 0;
            for(int i = index ; i > 0 ; i -= lowBit(i)) {
                result += array[i];
            }
            return result;
        }
    }
}
