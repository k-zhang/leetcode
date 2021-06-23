package com.algomind.leetcode.reverselinkedlist2;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;

        ListNode pLeft = null, pStart = null, pEnd = null, pRight;
        ListNode current = head;
        for(int i = 1 ; i <= right; i ++) {
            if(i == left - 1) pLeft = current;
            else if(i == left) pStart = current;
            else if(i == right) pEnd = current;

            current = current.next;
        }
        pRight = pEnd.next;

        ListNode p = pStart, s = pStart.next;
        while(s != pRight) {
            ListNode temp = s.next;
            s.next = p;
            p = s;
            s = temp;
        }

        pStart.next = pRight;

        if(pLeft != null) pLeft.next = pEnd;
        else head = pEnd;

        return head;
    }
}
