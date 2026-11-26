package com.questions;

import java.util.*;

/*
O(n) - time complexity
Runtime - 16 ms
Memory - 44.5 MB
*/
public class _3_Longest_Substring_Without_Repeating_Characters_01 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Example 1: got " + s.lengthOfLongestSubstring("abcabcbb") + "   expected 3");
        System.out.println("Example 2: got " + s.lengthOfLongestSubstring("pwwkew") + "   expected 3");
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if( s.length() == 0 )
                return 0;
            HashMap<Character, Integer> map = new HashMap<>();
            int res = 1;
            int temp, prev, last;
            prev = 1;
            last = 0;
            map.put( s.charAt(0), 0);
            for(int i=1 ; i<s.length() ; i++){
                if( !map.containsKey(s.charAt(i)) || map.get(s.charAt(i)) < last){
                    temp = prev + 1;
                }
                else{
                    temp = i - map.get(s.charAt(i));
                    last = map.get(s.charAt(i)) + 1;
                }
                map.put( s.charAt(i), i);
                prev = temp;
                if( res < temp ){
                    res = temp;
                }
            }
            return res;
        }
    }
}
