package com.algomind.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;

        var result = new ArrayList<Integer>();

        int left = -1, right = -1;

        if(x < arr[0] || x > arr[n - 1]) {
            if (x < arr[0]) {
                left = 0;
                right = left + k - 1;
            } else if (x > arr[n - 1]) {
                right = n - 1;
                left = right - k + 1;
            }
        }else{
            for(int i = 0 ; i < n ; i ++) {
                if(arr[i] == x) {
                    left = right = i;
                    break;
                }else if(arr[i] < x && arr[i + 1] > x) {
                    if(Math.abs(arr[i] - x) <=  Math.abs(arr[i + 1] - x)) {
                        left = right = i;
                    }else{
                        left = right = i + 1;
                    }
                    break;
                }
            }

            for(int i = 0 ; i < k - 1 ; i ++) {
                if(right + 1 == n || (left != 0 && Math.abs(arr[left - 1] - x) <=  Math.abs(arr[right + 1] - x))) {
                    left = left - 1;
                }else{
                    right = right + 1;
                }
            }
        }

        for(int i = left ; i <= right ; i ++) {
            result.add(arr[i]);
        }

        return result;
    }

    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        var left = 0;
        var right = arr.length - k;

        while (left < right) {
            var mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        var result = new ArrayList<Integer>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
