package com.algomind.leetcode.mergesortedarray;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];

        int p1 = 0, p2 = 0;
        int pr = 0;
        while(p1 < m || p2 < n) {
            if(p1 != m && (p2 == n || nums1[p1] <= nums2[p2])) {
                result[pr] = nums1[p1];
                p1++;
            }else{
                result[pr] = nums2[p2];
                p2++;
            }
            pr++;
        }

        System.arraycopy(result, 0, nums1, 0, m+n);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int pr = m + n - 1;

        while(p1 >= 0 || p2 >= 0) {
            if(p1 < 0) {
                nums1[pr] = nums2[p2];
                p2--;
            }else if(p2 < 0) {
                nums1[pr] = nums1[p1];
                p1--;
            }else {
                if (nums1[p1] >= nums2[p2]) {
                    nums1[pr] = nums1[p1];
                    p1--;
                } else {
                    nums1[pr] = nums2[p2];
                    p2--;
                }
            }
            pr--;
        }
    }
}
