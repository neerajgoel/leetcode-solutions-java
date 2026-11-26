package com.questions;

import java.util.*;

/*
 NOTE: despite the file name, this solves LeetCode 152 - Maximum Product Subarray
 (https://leetcode.com/problems/maximum-product-subarray/)
 Runtime Complexity - O(n)
*/
public class _153_find_minimum_in_rotated_sorted_array_01 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Example 1: got " + s.maxProduct(new int[]{2, 3, -2, 4}) + "   expected 6");
        System.out.println("Example 2: got " + s.maxProduct(new int[]{-2, 0, -1}) + "   expected 0");
    }

    static class Solution {

        public int maxProduct(int[] nums) {
            int res = Integer.MIN_VALUE;
            int l = 1;
            int r = 1;
            int m;
            for(int i=0 ; i<nums.length ; i++){
                l *= nums[i];
                r *= nums[nums.length - i - 1];
                m = Math.max(l, r);
                if( res < m ){
                    res = m;
                }
                if( l == 0)
                    l = 1;
                if( r == 0 )
                    r = 1;
            }
            return res;
        }
    }
}
