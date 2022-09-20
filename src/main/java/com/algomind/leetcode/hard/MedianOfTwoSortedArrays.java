package com.algomind.leetcode.hard;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if(totalLength == 0) return 0d;

        if(totalLength % 2 == 1) {
            return findKthElement(nums1, nums2, totalLength / 2 + 1);
        }else{
            return (findKthElement(nums1, nums2, totalLength / 2) + findKthElement(nums1, nums2, totalLength / 2 + 1)) / 2d;
        }
    }

    private int findKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1 = 0, index2 = 0;

        while(true) {
            if(index1 == length1) {
                return nums2[index2 + k - 1];
            }else if(index2 == length2){
                return nums1[index1 + k - 1];
            }

            if(k == 1) return Math.min(nums1[index1], nums2[index2]);

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half - 1, length1-1);
            int newIndex2 = Math.min(index2 + half - 1, length2-1);
            int newNumber1 = nums1[newIndex1];
            int newNumber2 = nums2[newIndex2];

            if(newNumber1 <= newNumber2) {
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }else{
                k = k - (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    // O(m+n) complexity. Do not match requirement.
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0) return 0d;

        int length = nums1.length + nums2.length;
        boolean isOdd = length % 2 == 1;
        int mid = length / 2;

        int p1 = 0, p2 = 0;
        int count = 0;
        int[] numbers = new int[2];
        while(count <= mid) {
            int currentNumber;
            if(p2 == nums2.length || (p1 < nums1.length && nums1[p1] <= nums2[p2])) {
                currentNumber = nums1[p1];
                p1++;
            }else{
                currentNumber = nums2[p2];
                p2++;
            }

            numbers[1] = numbers[0];
            numbers[0] = currentNumber;
            count++;
        }

        if(isOdd) {
            return numbers[0];
        }else{
            return (numbers[0] + numbers[1]) / 2d;
        }
    }
}
