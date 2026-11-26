package com.questions;

import java.util.*;

/*
 Dynamic programming with an array
 res[i] = best loot from houses 0..i = max(res[i-1], res[i-2] + nums[i])
 Runtime Complexity - O(n)
 Space Complexity - O(n)
*/
public class _198_House_Robber_01 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Example 1: got " + s.rob(new int[]{1, 2, 3, 1}) + "   expected 4");
        System.out.println("Example 2: got " + s.rob(new int[]{2, 7, 9, 3, 1}) + "   expected 12");
        System.out.println("Video street: got " + s.rob(new int[]{10, 11, 10, 2, 1, 9, 10, 8}) + "   expected 37");
    }

    static class Solution {
        public int rob(int[] nums) {

            if( nums.length <= 1 ){
                return nums[nums.length - 1];
            }

            if( nums.length == 2 ){
                return Math.max(nums[0], nums[1]);
            }

            int res[] = new int[nums.length];

            res[0] = nums[0];
            res[1] = Math.max(nums[0], nums[1]);

            for(int i=2 ; i<nums.length ; i++){
                res[i] = Math.max( res[i-1], res[i-2] + nums[i] );
            }

            return res[res.length - 1];
        }
    }
}
