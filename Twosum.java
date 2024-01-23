import java.util.HashMap;
import java.util.Map;

public class Twosum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndices = new HashMap<>();

      
        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];
           
            if (numIndices.containsKey(complement)) {
                return new int[]{numIndices.get(complement), i};
            }

            numIndices.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two numbers found that add up to the target");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 12};
        int target = 9;
        int[] result = twoSum(nums, target);

        // Print the result
        if (result != null) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No solution found.");
        }
    }
}
