package com.iimtiaz.day_23;

public class MergeTwoSortedLists {
    public static void main(String[] args) {

        // Create first sorted linked list: 1 -> 2 -> 4
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        // Create second sorted linked list: 1 -> 3 -> 4
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        // Merge the two sorted linked lists
        Solution solution = new Solution();
        ListNode merged = solution.mergeTwoLists(l1, l2);

        // Print the merged linked list
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }

    }
}


/**
 * Time Complexity: The time complexity is O(n + m), where n and m are the lengths of "l1" and "l2", respectively.
 * <p>
 * Space Complexity: The space complexity is O(1). This is because we are only allocating a few extra variables and
 * are not using any data structure that scales with the size of the input.
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // merge the remaining nodes
        prev.next = l1 != null ? l1 : l2;

        return prehead.next;
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
