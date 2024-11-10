package com.iimtiaz.day_22;

public class MergeIntervals {
    public static void main(String[] args) {
        // Create a linked list
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        // Call the reverseKGroup method
        Solution solution = new Solution();
        ListNode reversed = solution.reverseKGroup(node1, 2);

        // Print the reversed linked list
        ListNode current = reversed;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}

/**
 * Time Complexity: O(n)
 * <p>
 * Recursive Calls: The algorithm makes recursive calls to reverse each group of k nodes, but it visits each node only
 * once across all recursive calls.
 * Constant-Time Operations: The operations within each call, such as counting, pointer manipulation, and reversing,
 * are constant-time operations.
 * Space Complexity: O(n/k) in the best case, O(n) in the worst case
 * <p>
 * Recursion Stack: The recursion stack can grow up to a depth of n/k in the best case (when the list length is a
 * multiple of k), resulting in a space complexity of O(n/k).
 * Worst Case: In the worst case (when the list length is not a multiple of k), the recursion depth can reach n,
 * leading to O(n) space complexity.
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //1. test weather we have more then k node left, if less then k node left we just return head
        ListNode node = head;
        int count = 0;
        while (count < k) {
            if (node == null) return head;
            node = node.next;
            count++;
        }
        // 2.reverse k node at current level
        ListNode pre = reverseKGroup(node, k); //pre node point to the the answer of sub-problem
        while (count > 0) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            count = count - 1;
        }
        return pre;
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
