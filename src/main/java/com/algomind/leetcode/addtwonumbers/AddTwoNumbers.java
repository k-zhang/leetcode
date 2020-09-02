package com.algomind.leetcode.addtwonumbers;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode pl1 = l1;
        ListNode pl2 = l2;

        ListNode head = null;
        ListNode tail = head;
        while(pl1 != null || pl2 != null || carry != 0) {
            int result = calculate(pl1, pl2, carry);
            ListNode resultNode;
            if(result < 10) {
                resultNode = new ListNode(result);
                carry = 0;
            }else{
                resultNode = new ListNode(result % 10);
                carry = result / 10;
            }

            if(head == null) {
                head = resultNode;
                tail = head;
            }else{
                tail.next = resultNode;
                tail = tail.next;
            }

            if(pl1 != null) pl1 = pl1.next;
            if(pl2 != null) pl2 = pl2.next;
        }

        return head;
    }

    private int calculate(ListNode pl1, ListNode pl2, int carry) {
        if(pl1 != null && pl2 != null) {
            return pl1.val + pl2.val + carry;
        }else if(pl1 != null) {
            return pl1.val + carry;
        }else if(pl2 != null) {
            return pl2.val + carry;
        }else{
            return carry;
        }
    }
}
