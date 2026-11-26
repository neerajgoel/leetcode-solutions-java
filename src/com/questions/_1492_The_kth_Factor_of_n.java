package com.questions;

import java.util.*;

/*
 Runtime Complexity - O(n)
 Runtime - 0 ms
 Beats - 100%

 Memory - 40.49 MB
 Beats - 36.04%
*/
public class _1492_The_kth_Factor_of_n {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Example 1: got " + s.kthFactor(12, 3) + "   expected 3");
        System.out.println("Example 2: got " + s.kthFactor(4, 4) + "   expected -1");
    }

    static class Solution {

        public int kthFactor(int n, int k) {
            int count = 0;
            for(int i=1 ; i<=n ; i++){
                if( n % i == 0 ){
                    count++;
                    if( count == k ){
                        return i;
                    }
                }
            }
            return -1;
        }

    }
}
