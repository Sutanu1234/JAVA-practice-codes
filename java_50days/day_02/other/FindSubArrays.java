package com.iimtiaz.day_02.other;

import java.util.ArrayList;
import java.util.List;

public class FindSubArrays {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        List<List<Integer>> result = findAllSubarray(nums);
        for (List<Integer> subarray : result) {
            System.out.println("Subarray: " + subarray);
            Integer r = 0;
            for (Integer s : subarray) {
                r += s;
            }
            System.out.println("Sum: " + r);
            System.out.println();
        }
    }

    public static List<List<Integer>> findAllSubarray(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //The outer loop variable size starts at 0 (empty subarray) and goes up to the length of the nums array
        // (largest possible subarray).
        for (int size = 0; size <= nums.length; size++) {
            //The variable start starts at 0 and goes up to the length minus the current size, ensuring the subarray
            // ends within the nums array.
            for (int start = 0; start + size <= nums.length; start++) {
                //Creates a new empty List<Integer> for each iteration of the inner loop.
                //It then iterates from the current start position to start plus the current size.
                //Within the inner loop, each element at index i from the nums array is added to the subarray list.
                List<Integer> subarray = new ArrayList<>();
                for (int i = start; i < start + size; i++) {
                    subarray.add(nums[i]);
                }
                result.add(subarray);
            }
        }
        return result;
    }
}

//        In Java, the concept of a subarray usually refers to a contiguous sequence of elements within
//        an array. So, [-2, 1] and [1, -2] would be considered different subarrays because they
//        contain the same elements but in a different order.