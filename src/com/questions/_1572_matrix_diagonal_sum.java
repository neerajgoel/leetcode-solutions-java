package com.questions;

import java.util.*;

/*
 Runtime Complexity - O(n)
 Runtime - 0 ms
 Memory - 42.6 MB
*/
public class _1572_matrix_diagonal_sum {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Example 1: got " + s.diagonalSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}) + "   expected 25");
        System.out.println("Example 2: got " + s.diagonalSum(new int[][]{{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}}) + "   expected 8");
    }

    static class Solution {
        public int diagonalSum(int[][] mat) {
            int sum = 0;
            int mid = mat.length/2 ;
            for(int i=0 ; i<mat.length ; i++){
                sum += mat[i][i];
                if( mat.length % 2 != 0 && i == mid ){
                    continue;
                }
                sum += mat[i][mat.length - i - 1];
            }
            return sum;
        }
    }
}
