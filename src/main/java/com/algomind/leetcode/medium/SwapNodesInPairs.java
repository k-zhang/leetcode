package com.algomind.leetcode.medium;

import com.algomind.leetcode.common.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode pLeft = head, pRight = head.next;
        ListNode nextPairFirst = pRight.next;
        head = pRight;

        while(pLeft != null && pLeft.next != null) {
            if(pRight != null) nextPairFirst = pRight.next;
            pRight.next = pLeft;
            pLeft.next = (nextPairFirst == null || nextPairFirst.next == null) ? nextPairFirst : nextPairFirst.next;
            pLeft = nextPairFirst;
            pRight = pLeft == null ? null : pLeft.next;
        }

        return head;
    }

    public ListNode swapPairs1(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode nextToHead = head.next;
        head.next = swapPairs1(nextToHead.next);
        nextToHead.next = head;

        return nextToHead;
    }
}
