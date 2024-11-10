package com.iimtiaz.day_24;

public class AddTwoNumbers {
    public static void main(String[] args) {
        // Create two numbers using ListNode. For example, we'll create 342 and 465:
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Create a Solution object
        Solution solution = new Solution();

        // Add the two numbers
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
            if (result != null) {
                System.out.print(" -> ");
            }
        }
    }
}

/**
 * The time complexity of the provided Java solution is O(max(n, m)), where n and m represent the lengths of the two
 * input linked lists. This is because we iterate through the two linked lists in parallel, and in the worst case,
 * this results in the length of the longer list.
 * The space complexity is also O(max(n, m)). The length of the new list is at most max(n, m) + 1. This is because the
 * length of the new list is at most the length of the longer input list plus the carry-over from the last sum operation.
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
