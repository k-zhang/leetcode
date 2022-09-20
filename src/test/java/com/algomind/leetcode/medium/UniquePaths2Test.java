package com.algomind.leetcode.medium;

import com.algomind.leetcode.common.ListNode;
import com.algomind.leetcode.easy.ReverseLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UniquePaths2Test {
    private final UniquePaths2 uniquePaths2 = new UniquePaths2();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int expected, int[][] obstacleGrid) {
        Assertions.assertEquals(expected, uniquePaths2.uniquePathsWithObstacles(obstacleGrid));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(2, new int[][]{{0,0,0},{0,1,0},{0,0,0}}),
                Arguments.of(1, new int[][]{{0,1},{0,0}}),
                Arguments.of(0, new int[][]{{1,0,0},{0,0,0},{0,0,0}}),
                Arguments.of(0, new int[][]{{0,0,0},{0,0,0},{0,0,1}}),
                Arguments.of(4, new int[][]{{0,0,0,0,0,0,0},{0,0,1,0,0,0,0},{0,1,0,0,0,1,0}})
        );
    }

    static class ReverseLinkedListTest {
        private final ReverseLinkedList solution = new ReverseLinkedList();

        @ParameterizedTest
        @MethodSource("provideData")
        public void test(int[] expected, int[] input) {
            ListNode listNode = toLinkedList(input);

            ListNode current = solution.reverseList(listNode);
            for (int j : expected) {
                Assertions.assertEquals(j, current.val);
                current = current.next;
            }

            Assertions.assertNull(current);
        }

        private ListNode toLinkedList(int[] input) {
            ListNode head = null;
            ListNode last = null;
            ListNode current;
            for (int j : input) {
                current = new ListNode();
                if(head == null) head = current;
                else {
                    last.next = current;
                }

                last = current;
                current.val = j;
            }
            return head;
        }

        private static Stream<Arguments> provideData() {
            return Stream.of(
                Arguments.of(new int[]{5,4,3,2,1}, new int[]{1,2,3,4,5}),
                Arguments.of(new int[]{2,1}, new int[]{1,2}),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{}, new int[]{})
            );
        }
    }

    static class PaintHouseTest {
        private final PaintHouse paintHouse = new PaintHouse();

        @ParameterizedTest
        @MethodSource("provideData")
        public void test(int expected, int[][] x){
            Assertions.assertEquals(expected, paintHouse.minCost(x));
        }

        private static Stream<Arguments> provideData() {
            return Stream.of(
                    Arguments.of(2, new int[][]{{7,6,2}}),
                    Arguments.of(10, new int[][]{{17,2,17},{16,16,5},{14,3,19}}),
                    Arguments.of(12, new int[][]{{1,10,15},{2,100,8},{15,3,100}}),
                    Arguments.of(8, new int[][]{{1000,1000,1},{17,4,3},{15,1,3}}),
                    Arguments.of(27, new int[][]{{1,10,15},{2,100,8},{15,3,100},{17,3,50}}),
                    Arguments.of(1002, new int[][]{{1,10,15},{1,1000,1000},{1,10000,100000}}),
                    Arguments.of(82, new int[][]{{20,17,16},{10,14,15},{7,12,20},{4,9,3},{19,2,1},{7,7,16},{13,7,20},{19,11,6},{1,13,7},{2,13,4},{6,19,8},{17,9,19}})
            );
        }

    }
}