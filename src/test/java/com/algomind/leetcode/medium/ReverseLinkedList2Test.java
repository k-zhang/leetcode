package com.algomind.leetcode.medium;

import com.algomind.leetcode.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ReverseLinkedList2Test {
    private final ReverseLinkedListII solution = new ReverseLinkedListII();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[] expected, int[] input, int left, int right) {
        ListNode listNode = toLinkedList(input);
        ListNode result = solution.reverseBetween2(listNode, left, right);

        ListNode current = result;
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
                Arguments.of(new int[]{1,4,3,2,5}, new int[]{1,2,3,4,5}, 2, 4),
                Arguments.of(new int[]{5}, new int[]{5}, 1, 1),
                Arguments.of(new int[]{1,2,3}, new int[]{1,2,3}, 2, 2),
                Arguments.of(new int[]{1,3,2}, new int[]{1,2,3}, 2, 3),
                Arguments.of(new int[]{3,2,1}, new int[]{1,2,3}, 1, 3),
                Arguments.of(new int[]{2,1,3}, new int[]{1,2,3}, 1, 2),
                Arguments.of(new int[]{7,6,5,4,3,2,1}, new int[]{1,2,3,4,5,6,7}, 1, 7),
                Arguments.of(new int[]{2,1,3,4,5,6,7}, new int[]{1,2,3,4,5,6,7}, 1, 2),
                Arguments.of(new int[]{1,2,3,4,5,7,6}, new int[]{1,2,3,4,5,6,7}, 6, 7),
                Arguments.of(new int[]{6,5,4,3,2,1,7}, new int[]{1,2,3,4,5,6,7}, 1, 6),
                Arguments.of(new int[]{1,7,6,5,4,3,2}, new int[]{1,2,3,4,5,6,7}, 2, 7)
        );
    }
}