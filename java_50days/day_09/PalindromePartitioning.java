package com.iimtiaz.day_09;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new Solution_1().partition(s));

    }
}

/**
 * Time Complexity:
 * <p>
 * Worst-case: O(n * 2^n), where n is the length of the input string.
 * Explanation:
 * The solveRecBacktracking function potentially calls itself recursively for each possible substring, leading to a
 * branching factor of up to n.
 * Each recursive call involves checking for palindromes, which takes O(n) time in the worst case.
 * The overall time complexity is exponential due to the recursive exploration of potentially 2^n combinations of substrings.
 * Space Complexity:
 * <p>
 * O(n * 2^n) in the worst case, primarily due to the recursion stack and the result list.
 * Explanation:
 * The recursion stack can grow up to a depth of n, storing intermediate states of the partitioning process.
 * The res list can potentially hold up to 2^n unique palindrome partitions, each containing up to n strings, resulting
 * in a worst-case space usage of n * 2^n.
 */
class Solution_1 {
    // Checking the given substring is palindrome
    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    private void solveRecBacktracking(String s, int idx, List<List<String>> res, List<String> l) {
        //Edge or Base Case
        if (s.length() == idx) {
            res.add(new ArrayList<>(l));
            return;
        }

        // backtracking
        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                l.add(s.substring(idx, i + 1));
                solveRecBacktracking(s, i + 1, res, l);
                l.remove(l.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        solveRecBacktracking(s, 0, res, new ArrayList<>());
        return res;
    }
}

// https://leetcode.com/problems/palindrome-partitioning/description/