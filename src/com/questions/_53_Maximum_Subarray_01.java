package com.questions;

import java.util.*;

/*
 Runtime Complexity - O(n)
 Runtime - 2 ms
 Memory - 73.9 MB
*/
public class _53_Maximum_Subarray_01 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Example 1: got " + s.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) + "   expected 6");
        System.out.println("Example 2: got " + s.maxSubArray(new int[]{5, 4, -1, 7, 8}) + "   expected 23");
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            boolean allNeg = true;
            int result = Integer.MIN_VALUE;
            for(int i : nums){
                if( result < i ){
                    result = i;
                }
                if( i >= 0 ){
                    allNeg = false;
                    break;
                }
            }
            if( allNeg ){
                return result;
            }
            result = Integer.MIN_VALUE;
            int tmp = 0;
            for(int i : nums){
                tmp += i;
                if( result < tmp ){
                    result = tmp;
                }
                if( tmp < 0 ){
                    tmp = 0;
                }
            }
            return result;
        }
    }
}
