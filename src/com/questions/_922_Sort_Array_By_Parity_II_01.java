package com.questions;

import java.util.*;

/*
 Runtime Complexity - O(n)
 Runtime - 2 ms
 Memory - 43.3 MB
*/
public class _922_Sort_Array_By_Parity_II_01 {

    public static void main(String[] args) {
        System.out.println("Example 1: got " + Arrays.toString(new Solution().sortArrayByParityII(new int[]{4, 2, 5, 7})) + "   expected [4, 5, 2, 7] (any valid order)");
        System.out.println("Example 2: got " + Arrays.toString(new Solution().sortArrayByParityII(new int[]{2, 3})) + "   expected [2, 3]");
    }

    static class Solution {

        public int[] sortArrayByParityII(int[] nums) {
            int i, j, temp;
            i = 0;
            j = 1;
            while( i < nums.length && j < nums.length){
                while( i < nums.length && nums[i] % 2 == 0 ){
                    i += 2;
                }
                while( j < nums.length && nums[j] %2 != 0){
                    j += 2;
                }
                if( i < nums.length && j < nums.length ){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            return nums;
        }
    }
}
