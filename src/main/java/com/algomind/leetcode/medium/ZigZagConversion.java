package com.algomind.leetcode.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ZigZagConversion {
    public String convert1(String s, int numRows) {
        int groupSize = numRows * 2 - 2;
        groupSize = groupSize == 0 ? 1 : groupSize;
        String[] groups = s.split("(?<=\\G.{" + groupSize + "})");

        char[][] groupArray = Arrays.stream(groups).map(String::toCharArray).toArray(char[][]::new);

        // Generate selection list
        int[][] selectionList = new int[numRows][];
        for(int i = 0 ; i < numRows ; i++) {
            int[] selections = i == 0 || i == numRows - 1 ? new int[]{i} : new int[]{i, 2 * (numRows-1) - i};
            selectionList[i] = selections;
        }

        StringBuilder sb = new StringBuilder();
        for (int[] selections : selectionList) {
            for (char[] group : groupArray) {
               for (int select : selections) {
                   if (select < group.length) {
                       char selected = group[select];
                        sb.append(selected);
                    }
                }
            }
        }

        return sb.toString();
    }

    public String convert2(String s, int numRows) {
        final int groupSize = numRows * 2 - 2 == 0 ? 1 : numRows * 2 - 2;
        int[] groupBaseIndex = IntStream.iterate(0, n-> n < s.length(), n -> n + groupSize)
                .toArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < numRows ; i++) {
            for (int baseIndex : groupBaseIndex) {
                int indexOfChar1 = baseIndex + i;
                if (indexOfChar1 < s.length()) {
                    char selected = s.charAt(indexOfChar1);
                    sb.append(selected);
                }

                if(i != 0 && i != numRows - 1) {
                    int indexOfChar2 = baseIndex + 2 * (numRows-1) - i;
                    if (indexOfChar2 < s.length()) {
                        sb.append(s.charAt(indexOfChar2 ));
                    }
                }
            }
        }

        return sb.toString();
    }
}
