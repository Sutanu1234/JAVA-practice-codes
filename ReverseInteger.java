/* 
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321 
*/

  
class Solution {
    public int reverse(int x) {
        //Method 1
/*
        boolean isNegative = x < 0;
        String num = String.valueOf(Math.abs(x));

        StringBuilder in = new StringBuilder(num);
        in.reverse();

        String snum = in.toString();

        try {
            int reversedNumber = Integer.parseInt(snum);
            return isNegative ? -reversedNumber : reversedNumber;
        } catch (NumberFormatException e) {
            return 0;
        }
*/

        //Method 2

        boolean isNegative = x < 0;
        long absX = Math.abs((long) x);
        long reversed = 0;

        // Reverse the digits
        while (absX > 0) {
            reversed = reversed * 10 + absX % 10;
            absX /= 10;
        }

        // Check for overflow
        if (reversed > Integer.MAX_VALUE) {
            return 0;
        }

        // Restore sign if necessary
        return isNegative ? (int) -reversed : (int) reversed;
    }
}
