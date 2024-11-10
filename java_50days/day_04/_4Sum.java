package com.iimtiaz.day_04;

import java.util.*;

public class _4Sum {
    public static void main(String[] args) {

        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(new Solution_1().fourSum(nums, target));
        System.out.println();

    }
}

/**
 * Time Complexity: The time complexity of the code is O(n3), where n
 * is the length of the input array. This is because the code uses

 * Space Complexity: The space complexity of the code is O(n), where n
 * is the length of the input array. This is due to the additional space
 * required for the set and list data structures. In the worst case, the set
 * and list can store all elements of the array, hence the space complexity is linear.
 */

class Solution_1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        s.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        output.addAll(s);
        return output;
    }
}

//https://leetcode.com/problems/4sum/