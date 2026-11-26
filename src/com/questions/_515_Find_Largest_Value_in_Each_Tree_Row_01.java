package com.questions;

import java.util.*;

/*
 Runtime Complexity - O(n)
 Runtime - 0 ms
 Memory - 45.49 MB
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class _515_Find_Largest_Value_in_Each_Tree_Row_01 {

    public static void main(String[] args) {
        System.out.println("Example 1: got " + new Solution().largestValues(tree(1, 3, 2, 5, 3, null, 9)) + "   expected [1, 3, 9]");
        System.out.println("Example 2: got " + new Solution().largestValues(tree(1, 2, 3)) + "   expected [1, 3]");
    }

    // LeetCode's TreeNode
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Builds a tree from LeetCode's level-order array, e.g. tree(3, 9, 20, null, null, 15, 7)
    static TreeNode tree(Integer... v) {
        if (v.length == 0 || v[0] == null) return null;
        TreeNode root = new TreeNode(v[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (i < v.length) {
            TreeNode node = queue.poll();
            if (v[i] != null) { node.left = new TreeNode(v[i]); queue.add(node.left); }
            i++;
            if (i < v.length && v[i] != null) { node.right = new TreeNode(v[i]); queue.add(node.right); }
            i++;
        }
        return root;
    }

    static class Solution {

        static void findLargestValue(TreeNode node, ArrayList<Integer> result, int level){
            if( node != null ){
                // visit
                if( result.isEmpty() || result.size() <= level){
                    result.add(node.val);
                }
                else{
                    int currentValue = result.get(level);
                    if( currentValue < node.val ){
                        result.set(level, node.val);
                    }
                }
                // left
                findLargestValue(node.left, result, level + 1);
                // right
                findLargestValue(node.right, result, level + 1);
            }
        }

        public List<Integer> largestValues(TreeNode root) {
            ArrayList<Integer> result = new ArrayList<>();
            findLargestValue(root, result, 0);
            return result;
        }
    }
}
