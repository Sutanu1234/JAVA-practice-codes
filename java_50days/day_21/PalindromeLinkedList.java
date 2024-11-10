package com.iimtiaz.day_21;


public class PalindromeLinkedList {
    public static void main(String[] args) {
        // Create a palindrome linked list: 1 -> 2 -> 3 -> 2 -> 1
        ListNode node5 = new ListNode(1);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        // Create an instance of Solution class
        Solution solution = new Solution();

        // Check if the linked list is a palindrome
        boolean isPalindrome = solution.isPalindrome(node1);

        // Print the result
        System.out.println("Is the linked list a palindrome? " + isPalindrome);
    }
}

/**
 * Time Complexity: O(n)
 *
 * Single Recursive Pass: The algorithm makes a single recursive pass through the linked list, visiting each node once.
 * Constant-Time Operations: The operations within each recursive call, such as comparing values, updating pointers,
 * and returning, are constant-time operations.
 * Space Complexity: O(n)
 *
 * Recursion Stack: The recursion stack can grow up to a depth of n in the worst case (skewed linked list), leading to
 * a space complexity of O(n).
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // check basic case where there is only one element
        if (head.next == null) {
            return true;
        }
        ListNode node = checkHeadAndTail(head, head);
        return node != null;
    }

    public ListNode checkHeadAndTail(ListNode head, ListNode curr) {
        //if we reach at the bottom of the linked list we will compare it with the head of the linkedList, if they are
        // equal, we will return head.next to compare it with previous last element
        if (curr.next == null) {
            if (head.val == curr.val) {
                return head.next;
            } else {
                return null;
            }
        }

        ListNode node = checkHeadAndTail(head, curr.next);

        // if the head of the linkedlist also reaches to the end we will return a node;
        if (node != null && node.next == null) {
            return node;
        }

        //there, we are checking if the previous elements were equal or the current compatible elements are equal
        if (node == null || node.val != curr.val) {
            return null;
        }

        // if above if statement doesnt execute, it means we need to check next element
        return node.next;
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