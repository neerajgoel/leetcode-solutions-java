package com.questions;

import java.util.*;

/*
 Runtime Complexity - O(mn)
 Runtime - 13 ms
 Memory - 57.4 MB
*/
public class _200_Number_of_Islands_01 {

    public static void main(String[] args) {
        char[][] grid1 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}};
        char[][] grid2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}};
        System.out.println("Example 1: got " + new Solution().numIslands(grid1) + "   expected 1");
        System.out.println("Example 2: got " + new Solution().numIslands(grid2) + "   expected 3");
    }

    static class Solution {

        private int visit(char[][] grid, boolean[][] vis, int i, int j){
            if( grid[i][j] == '0'  || vis[i][j])
                return 0;
            int temp = 0;
            if( grid[i][j] == '1' && !vis[i][j]){
                temp++;
                vis[i][j] = true;
            }
            if( j > 0 )
                temp += visit(grid, vis, i, j - 1);
            if( j < grid[0].length - 1 )
                temp += visit(grid, vis, i, j + 1);
            if( i > 0 )
                temp += visit(grid, vis, i - 1, j);
            if( i < grid.length - 1 )
                temp += visit(grid, vis, i + 1, j);
            return temp;
        }

        public int numIslands(char[][] grid) {
            boolean vis[][] = new boolean[grid.length][grid[0].length];
            for(int i=0 ; i<grid.length ; i++){
                for(int j=0 ; j<grid[0].length ; j++){
                    vis[i][j] = false;
                }
            }
            int res = 0;
            int temp;
            for(int i=0 ; i<grid.length ; i++){
                for(int j=0 ; j<grid[0].length ; j++){
                    if( grid[i][j] == '1' && vis[i][j] == false ){
                        temp = visit(grid, vis, i, j);
                        if( temp > 0 )
                            res++;
                    }
                }
            }
            return res;
        }
    }
}
