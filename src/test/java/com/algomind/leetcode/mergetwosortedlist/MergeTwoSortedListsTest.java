package com.algomind.leetcode.mergetwosortedlist;

import com.algomind.leetcode.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MergeTwoSortedListsTest {
    private final MergeTwoSortedLists solution = new MergeTwoSortedLists();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[] expected, int[] input1, int[] input2) {
        ListNode l1 = toLinkedList(input1);
        ListNode l2 = toLinkedList(input2);

        ListNode current = solution.mergeTwoLists(l1, l2);
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
            Arguments.of(new int[]{1,1,2,3,4,4}, new int[]{1,2,4}, new int[]{1,3,4}),
            Arguments.of(new int[]{}, new int[]{}, new int[]{}),
            Arguments.of(new int[]{1}, new int[]{}, new int[]{1}),
            Arguments.of(new int[]{1}, new int[]{1}, new int[]{}),
            Arguments.of(new int[]{1,1,1,1,1,1,1,1}, new int[]{1,1,1,1}, new int[]{1,1,1,1}),
            Arguments.of(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}, new int[]{2,4,6,8,10,12,14}, new int[]{1,3,5,7,9,11,13,15}),
            Arguments.of(new int[]{2,4,6,8,9,10,12,14}, new int[]{2,4,6,8,10,12,14}, new int[]{9})
        );
    }
}