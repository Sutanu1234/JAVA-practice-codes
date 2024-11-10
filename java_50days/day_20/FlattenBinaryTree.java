package com.iimtiaz.day_20;

public class FlattenBinaryTree {
    public static void main(String[] args) {
        // Create a tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        // Call flatten method
        Solution solution = new Solution();
        solution.flatten(root);

        // Print the flattened tree
        TreeNode node = root;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.right;
        }

    }
}

/**
 Time and Space Complexity Analysis of flatten(TreeNode root):
 Time Complexity: O(n)
 Visiting Each Node Once: The algorithm visits each node in the tree exactly once, ensuring linear time complexity.
 Constant-Time Operations: The operations within the loop, such as checking pointers, assigning values, and moving
 pointers, are constant-time operations.
 Space Complexity: O(1)
 Constant Extra Space: The algorithm uses a constant amount of extra space for the head and curr pointers, regardless
 of the tree's size.
 */
class Solution {
    public void flatten(TreeNode root) {
        TreeNode head = null, curr = root;
        while (head != root) {
            if (curr.right == head) curr.right = null;
            if (curr.left == head) curr.left = null;
            if (curr.right != null) curr = curr.right;
            else if (curr.left != null) curr = curr.left;
            else {
                curr.right = head;
                head = curr;
                curr = root;
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}