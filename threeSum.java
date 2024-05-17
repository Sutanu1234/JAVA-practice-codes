class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /* Method 1
        
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        HashSet<Long> set = new HashSet<>();

        int teg = 0;
        for(int i = 0; i < nums.length; i++){
            int nteg = teg - nums[i];

            int li = i + 1;
            int ri = nums.length -1;
            while(li < ri){
                if(nums[li] + nums[ri] < nteg){
                    li++;
                }
                else if(nums[li] + nums[ri] > nteg){
                    ri--;
                }
                else{
                    long hash = getHash(nums[i], nums[li], nums[ri]);
                    if(set.contains(hash) == false){
                        ans.add(Arrays.asList(nums[i], nums[li], nums[ri]));
                        set.add(hash);
                    }
                    li++;
                    ri--;
                }
            }
        }

        return ans;
    }

    public long getHash(int x, int y, int z){
        long hash = x;

        hash *= 100000;
        hash += y;
        hash *= 100000;
        hash += z;

        return hash;
    }
    */

      // Method 2

    List<List<Integer>> result = new ArrayList<>();
        
        if (nums == null || nums.length < 3) {
            return result;
        }
        
        Arrays.sort(nums); // Sort the array to make it easier to skip duplicates and use two-pointer technique
        
        for (int i = 0; i < nums.length - 2; i++) {
            // If the current value is greater than zero, break from the loop. Remaining values cannot sum to zero.
            if (nums[i] > 0) {
                break;
            }
            
            // Skip the same `nums[i]` to avoid duplicates in the result
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    
                    // Skip the same `nums[left]` and `nums[right]` to avoid duplicates in the result
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++; // We need a larger sum, move the left pointer to the right
                } else {
                    right--; // We need a smaller sum, move the right pointer to the left
                }
            }
        }
        
        return result;
    }
}
