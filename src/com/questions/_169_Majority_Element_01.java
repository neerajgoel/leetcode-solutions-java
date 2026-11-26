package com.questions;

import java.util.*;

/*
 Runtime Complexity - O(n)
 Runtime - 1 ms
 Memory - 46.1 MB
*/
public class _169_Majority_Element_01 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Example 1: got " + s.majorityElement(new int[]{3, 2, 3}) + "   expected 3");
        System.out.println("Example 2: got " + s.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}) + "   expected 2");
    }

    static class Solution {
        public int majorityElement(int[] nums) {
            int majIndex = 0;
            int count = 1;
            for(int i=1 ; i<nums.length ; i++){
                if( nums[majIndex] == nums[i] ){
                    count++;
                }
                else{
                    count--;
                }
                if( count <= 0 ){
                    majIndex = i;
                    count = 1;
                }
            }
            return nums[majIndex];
        }
    }
}
