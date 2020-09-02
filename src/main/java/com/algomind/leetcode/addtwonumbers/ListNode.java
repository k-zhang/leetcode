package com.algomind.leetcode.addtwonumbers;

import java.util.Objects;

public class ListNode {
     int val;

     ListNode next;

     ListNode() {}

     ListNode(int val) {
         this.val = val;
     }

     ListNode(int val, ListNode next) {
         this.val = val; this.next = next;
     }

    @Override
    public String toString() {
         String result = String.valueOf(val);
         if(next != null) {
             result = result + " " + next.toString();
         }
         return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
