package com.algomind.leetcode.medium;

import com.algomind.leetcode.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SwapNodesInPairsTest {
    private final SwapNodesInPairs solution = new SwapNodesInPairs();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[] expected, int[] input) {
        ListNode head = toLinkedList(input);

        ListNode reversed = solution.swapPairs1(head);
        for (int j : expected) {
            Assertions.assertEquals(j, reversed.val);
            reversed = reversed.next;
        }
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
            Arguments.of(new int[]{2,1,4,3}, new int[]{1,2,3,4}),
            Arguments.of(new int[]{}, new int[]{}),
            Arguments.of(new int[]{1}, new int[]{1}),
            Arguments.of(new int[]{2,1}, new int[]{1,2}),
            Arguments.of(new int[]{2,1,3}, new int[]{1,2,3}),
            Arguments.of(new int[]{2,1,4,3,5}, new int[]{1,2,3,4,5})
        );
    }
}
