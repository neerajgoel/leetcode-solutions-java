package com.questions;

import java.util.*;

/*
Runtime complexity = O(mn)
Runtime - 6 ms
Memory - 46.8 MB
*/
public class _695_Max_Area_of_Island_01 {

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println("Example 1: got " + new Solution().maxAreaOfIsland(grid) + "   expected 6");
        System.out.println("Example 2: got " + new Solution().maxAreaOfIsland(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}}) + "   expected 0");
    }

    static class Solution {

        private int visit(int[][] grid, boolean[][] vis, int i, int j){
            if( grid[i][j] == 0  || vis[i][j])
                return 0;
            int temp = 0;
            if( grid[i][j] == 1 && !vis[i][j]){
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

        public int maxAreaOfIsland(int[][] grid) {
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
                    if( grid[i][j] == 1 && vis[i][j] == false ){
                        temp = visit(grid, vis, i, j);
                        if( res < temp )
                            res = temp;
                    }
                }
            }
            return res;
        }
    }
}
