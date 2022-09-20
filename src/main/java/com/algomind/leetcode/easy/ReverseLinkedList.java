package com.algomind.leetcode.easy;

import com.algomind.leetcode.common.ListNode;

public class ReverseLinkedList {
    // Iterative
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode current = head;
        ListNode next = head.next;

        while(next != null) {
            ListNode temp = next.next;
            next.next = current;
            current = next;
            next = temp;
        }

        head.next = null;
        return current;
    }

    // Recursive
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
