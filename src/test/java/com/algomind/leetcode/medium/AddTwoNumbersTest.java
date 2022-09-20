package com.algomind.leetcode.medium;

import com.algomind.leetcode.common.ListComparison;
import com.algomind.leetcode.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AddTwoNumbersTest {
    private final AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testAddTwoNumbers(ListNode expected, ListNode l1, ListNode l2) {
        var result = addTwoNumbers.addTwoNumbers(l1, l2);
        Assertions.assertTrue(ListComparison.areIdenticalLists(expected, result));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(toListNode(807), toListNode(342), toListNode(465)),
            Arguments.of(toListNode(0), toListNode(0), toListNode(0)),
            Arguments.of(toListNode(1), toListNode(0), toListNode(1)),
            Arguments.of(toListNode(1357), toListNode(123), toListNode(1234)),
            Arguments.of(toListNode(2998), toListNode(999), toListNode(1999))
        );
    }

    private static ListNode toListNode(int number) {
        if(number == 0) return new ListNode(0);

        ListNode p = null;
        ListNode tail = p;
        while(number != 0) {
            int pop = number % 10;
            number = number / 10;

            if(p == null) {
                p = new ListNode(pop);
                tail = p;
            }else{
                tail.next = new ListNode(pop);
                tail = tail.next;
            }
        }

        return p;
    }
}