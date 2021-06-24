package com.algomind.leetcode.reverselinkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ReverseLinkedListTest {
    private final ReverseLinkedList solution = new ReverseLinkedList();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[] expected, int[] input) {
        ListNode listNode = toLinkedList(input);
        ListNode result = solution.reverseList(listNode);

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
            Arguments.of(new int[]{5,4,3,2,1}, new int[]{1,2,3,4,5}),
            Arguments.of(new int[]{2,1}, new int[]{1,2}),
            Arguments.of(new int[]{1}, new int[]{1}),
            Arguments.of(new int[]{}, new int[]{})
        );
    }
}