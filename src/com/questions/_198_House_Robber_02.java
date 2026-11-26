package com.questions;

import java.util.*;

/*
 Dynamic programming with two variables (only the last two answers are ever needed)
 prev2 = best up to house i-2, prev1 = best up to house i-1
 Runtime Complexity - O(n)
 Space Complexity - O(1)
*/
public class _198_House_Robber_02 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Example 1: got " + s.rob(new int[]{1, 2, 3, 1}) + "   expected 4");
        System.out.println("Example 2: got " + s.rob(new int[]{2, 7, 9, 3, 1}) + "   expected 12");
        System.out.println("Video street: got " + s.rob(new int[]{10, 11, 10, 2, 1, 9, 10, 8}) + "   expected 37");
    }

    static class Solution {
        public int rob(int[] nums) {
            int prev2 = 0, prev1 = 0;
            for (int num : nums) {
                int cur = Math.max(prev1, prev2 + num);
                prev2 = prev1;
                prev1 = cur;
            }
            return prev1;
        }
    }
}
