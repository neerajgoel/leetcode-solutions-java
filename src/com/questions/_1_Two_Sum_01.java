package com.questions;

import java.util.*;

/*
 Runtime Complexity - O(n)
 Runtime - 32 ms
 Memory - 50.4 MB
*/
public class _1_Two_Sum_01 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Example 1: got " + Arrays.toString(s.twoSum(new int[]{2, 7, 11, 15}, 9)) + "   expected [0, 1]");
        System.out.println("Example 2: got " + Arrays.toString(s.twoSum(new int[]{3, 2, 4}, 6)) + "   expected [1, 2]");
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            int n;
            for(int i=0 ; i<nums.length ; i++ ){
                n = nums[i];
                if( !map.containsKey(n) ){
                    map.put(n, new ArrayList<>());
                }
                map.get(n).add(i) ;
            }
            int temp;
            for(int i=0 ; i<nums.length ; i++ ){
                n = nums[i];
                temp = target - n;
                if( n == temp && map.containsKey(n) && map.get(n).size() >= 2 ){
                    return new int[]{ map.get(n).get(0), map.get(n).get(1) };
                }
                else if( n != temp && map.containsKey(temp) ){
                    return new int[]{ i, map.get(temp).get(0) };
                }
            }
            return new int[]{};
        }
    }
}
