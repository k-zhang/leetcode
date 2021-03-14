package com.algomind.leetcode.containerwithmostwater;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int pLeft = 0, pRight = height.length-1;
        int area = (pRight - pLeft) * Math.min(height[pLeft], height[pRight]);
        int highestLeft = height[pLeft];
        int highestRight = height[pRight];

        while(pLeft < pRight) {
            if(height[pLeft] <= height[pRight]) {
                while(height[pLeft] <= highestLeft && pLeft < pRight) {
                    pLeft++;
                }
                if(pLeft < pRight) {
                    highestLeft = height[pLeft];
                }
            }else{
                while(height[pRight] <= highestRight && pLeft < pRight) {
                    pRight--;
                }
                if(pLeft < pRight) {
                    highestRight = height[pRight];
                }
            }

            if(pLeft < pRight) {
                int newArea = (pRight - pLeft) * Math.min(height[pLeft], height[pRight]);
                if (newArea > area) {
                    area = newArea;
                }
            }
        }

        return area;
    }
}
