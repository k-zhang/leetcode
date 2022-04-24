package com.algomind.leetcode.mergetwosortedlist;

import com.algomind.leetcode.common.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        else if(l2 == null) return l1;

        ListNode preHead = new ListNode(-1);
        ListNode p = preHead;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }

            p = p.next;
        }

        p.next = l1 == null ? l2 : l1;

        return preHead.next;
    }
}
