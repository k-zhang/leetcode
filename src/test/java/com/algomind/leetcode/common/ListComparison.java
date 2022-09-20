package com.algomind.leetcode.common;

public class ListComparison {
    public static boolean areIdenticalLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return true;

        if(list1 != null  && list2 != null) {
            return (list1.val == list2.val) && (areIdenticalLists(list1.next, list2.next));
        }

        return false;
    }
}
