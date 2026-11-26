package com.questions;

import java.util.*;

/*
 Runtime Complexity - O(n)
 Runtime - 1 ms
 Memory - 43.3 MB
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
public class _103_Binary_Tree_Zigzag_Level_Order_Traversal_01 {

    public static void main(String[] args) {
        System.out.println("Example 1: got " + new Solution().zigzagLevelOrder(tree(3, 9, 20, null, null, 15, 7)) + "   expected [[3], [20, 9], [15, 7]]");
        System.out.println("Example 2: got " + new Solution().zigzagLevelOrder(tree(1)) + "   expected [[1]]");
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if( root == null ){
                return result; 
            }
            Queue<TreeNode> que = new LinkedList<>();
            que.add(root);
            que.add(null);
            boolean leftToRight = true;
            List<Integer> currentRow = new ArrayList<>();
            while( !que.isEmpty() ){
                TreeNode node = que.poll();
                if( node == null ){
                    // last level completed
                    // insert it in result
                    if( !leftToRight ){
                        Collections.reverse(currentRow);
                    }
                    result.add( currentRow );
                    currentRow = new ArrayList<>();
                    leftToRight = !leftToRight;
                    if( que.isEmpty() ){
                        break;
                    }
                    que.add(null);
                    continue;
                }
                currentRow.add( node.val );
                if( node.left != null ){
                    que.add( node.left );
                }
                if( node.right != null ){
                    que.add( node.right );
                }
            }
            return result;
        }
    }
}
