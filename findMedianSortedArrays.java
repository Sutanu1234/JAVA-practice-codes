class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int num3 = nums1.length + nums2.length;

        int[] result = new int[num3];

        for(int i = 0; i < nums1.length; i++){
            result[i] = nums1[i];
        }
        for(int i = 0; i < nums2.length; i++){
            result[nums1.length + i] = nums2[i];
        }

        Arrays.sort(result);

        if(num3 % 2 != 0){
            return (double)result[num3 / 2];
        }
        else{
            return (double)(result[(num3 - 1) / 2] + result[num3 / 2]) / 2.0;
        }

    }
}
