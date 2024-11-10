package com.iimtiaz.day_01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(new Solution_1().twoSum_1(nums, target)));
        System.out.println(Arrays.toString(new Solution_2().twoSum_2(nums, target)));
        System.out.println(Arrays.toString(new Solution_3().twoSum_3(nums, target)));
    }
}

/**
 * Time complexity: O(n^2)
 * O(1): Initializing variables like result.
 * O(n * n): Nested loop iterates through each element of the array
 * twice (n times for the outer loop and n times
 * for the inner loop).
 * O(1): Checking if i != j and comparing if nums[i] + nums[j] == target
 * are both constant time operations.

 * Space complexity: O(1)
 * Only a few constant-size variables are used (e.g., i, j, result).
 */
class Solution_1 {
    public int[] twoSum_1(int[] nums, int target) {
        int[] result = null;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i != j) {
                    if (nums[i] + nums[j] == target) {
                        result = new int[]{i, j};
                    }
                }
            }
        }
        return result;
    }
}

/**
 * Time complexity: O(n)
 * O(1): Initializing variables like numToIndex.
 * O(n): Single loop iterates through each element of the array once.
 * O(1): Hash table operations like containsKey, get, and put are generally considered constant time on average.

 * Space complexity: O(n)
 * The numToIndex Hash Table stores mappings between each element and its index, requiring space proportional
 * to the array size (n).
 */
class Solution_2 {
    public int[] twoSum_2(int[] nums, int target) {
        // Create a hash map to store encountered elements and their indices
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numToIndex.containsKey(complement)) {
                // Found a valid pair
                return new int[]{numToIndex.get(complement), i};
            }
            // Add the current number and its index to the map
            numToIndex.put(nums[i], i);
        }
        // No valid pair found
        return new int[0];
    }
}

/**
 * Time complexity: O(n) (linear time)
 * We iterate through the array twice:
 * First, we build the hash map by adding each element to it. This takes O(n) time.
 * Next, we find the complement for each element and check if it exists in the map.
 * This also takes O(n) time. Therefore, the overall time complexity is O(n).

 * Space complexity: O(n) (linear space)
 * We use a hash map (numMap) to store encountered elements and their indices.
 * The space required depends on the number of items stored in the hash map.
 * In the worst case, when all elements are unique, the map stores exactly n elements.
 * Therefore, the space complexity is O(n).
 */
class Solution_3 {
    public int[] twoSum_3(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;
        // Build the hash table
        for (int i = 0; i < n; i++) {
            numMap.put(nums[i], i);
        }
        // We check if the hash map (numMap) contains the calculated complement.
        // Additionally, we ensure that the complement’s index is not the same as the current index i.
        // If both conditions are met, we found a valid pair of indices.
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement) && numMap.get(complement) != i) {
                return new int[]{i, numMap.get(complement)};
            }
        }
        // No solution found
        return new int[]{};
    }
}

// https://leetcode.com/problems/two-sum/
// Keyword: array.length vs string.length(), null VS [],
// Learned: Arrays.toString(), Map -> HashMap,
// Note:
// Follow up:
    // 1. Return if no pair is found then not found,
    // 2. If found multiple pair then return first pair and pair count,
    // 3, If found then return all pair and pair count,
    // 4. Assume for sorted array and unsorted array
