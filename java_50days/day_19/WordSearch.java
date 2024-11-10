package com.iimtiaz.day_19;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(new Solution().exist(board, word));
    }
}

// Time Complexity: O(N * 4^L), The space complexity is O(L)
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n]; // Track visited cells

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        if (index == word.length()) {
            return true; // Word found
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false; // Out of bounds or mismatch
        }

        visited[i][j] = true; // Mark cell as visited

        // Explore neighbors recursively
        boolean found = backtrack(board, word, index + 1, i + 1, j, visited)
                || backtrack(board, word, index + 1, i - 1, j, visited)
                || backtrack(board, word, index + 1, i, j + 1, visited)
                || backtrack(board, word, index + 1, i, j - 1, visited);

        visited[i][j] = false; // Backtrack: unmark cell for further exploration
        return found;
    }
}

