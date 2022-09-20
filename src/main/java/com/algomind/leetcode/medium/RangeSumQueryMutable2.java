package com.algomind.leetcode.medium;

// Solution using Binary Index Tree
public class RangeSumQueryMutable2 {
    private final int[] tree;
    private final int[] nums;
    private final int n;

    public RangeSumQueryMutable2(int[] nums) {
        this.nums = nums;
        n = nums.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }

    private int lowbit(int x) {
        return x & -x;
    }

    private int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) ans += tree[i];
        return ans;
    }

    private void add(int x, int u) {
        for (int i = x; i <= n; i += lowbit(i)) tree[i] += u;
    }

    public void update(int i, int val) {
        add(i + 1, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int l, int r) {
        return query(r + 1) - query(l);
    }
}
