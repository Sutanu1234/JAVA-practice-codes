package com.iimtiaz.day_04;

import java.util.*;

public class validParentheses {
    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(new Solution().minRemoveToMakeValid(s));

    }
}

/**
 Time Complexity:
 Iterating through the string: O(n), where n is the length of the input string.
 Stack operations: O(n) at most, as each character is pushed or popped at most once.
 Building the result string: O(n) to iterate through the character array and append valid characters.
 Overall Time Complexity: O(n) due to the dominance of string iteration and linear-time stack operations.

 Space Complexity:
 Character array: O(n) to store the characters of the input string.
 Stack: O(n) in the worst case if all characters are '(', requiring storage of their indices.
 StringBuilder: O(n) to build the final result string.
 Overall Space Complexity: O(n) due to the linear space usage of the character array, stack, and StringBuilder.
 */

class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();

        char ch[] = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') st.push(i);
            else if (ch[i] == ')') {
                if (st.isEmpty()) ch[i] = '#';
                else st.pop();
            }
        }
        while (!st.isEmpty()) {
            ch[st.pop()] = '#';
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != '#') sb.append(ch[i]);
        }
        return sb.toString();
    }
}

//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/