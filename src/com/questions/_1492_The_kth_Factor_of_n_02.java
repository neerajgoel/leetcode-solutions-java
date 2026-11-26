package com.questions;

import java.util.*;

/*
 Runtime Complexity - O(sqrt(n))
 Runtime - 0 ms
 Beats - 100%

 Memory - 40.20 MB
 Beats - 79.73%
*/
public class _1492_The_kth_Factor_of_n_02 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Example 1: got " + s.kthFactor(12, 3) + "   expected 3");
        System.out.println("Example 2: got " + s.kthFactor(4, 4) + "   expected -1");
    }

    static class Solution {

        public int kthFactor(int n, int k) {
            int sqrt = (int) Math.sqrt(n);
            int div;
            int count = 0;
            List<Integer> divisors = new ArrayList<>();
            for(int i=1 ; i<= sqrt ; i++){
                if( n % i == 0 ){
                    count++;
                    if( count == k ){
                        return i;
                    }
                    div = n / i;
                    if( div == i ){
                        continue;
                    }
                    divisors.add(div);
                }
            }
            for(int i=divisors.size()-1 ; i >= 0 ; i--){
                count++;
                if( count == k ){
                    return divisors.get(i);
                }
            }
            return -1;
        }

    }
}
