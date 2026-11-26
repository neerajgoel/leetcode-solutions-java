package com.questions;

import java.util.*;

/*
 Runtime Complexity - O(n)
 Runtime - 0 ms
 Memory - 40.1 MB
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
public class _993_Cousins_in_Binary_Tree_01 {

    public static void main(String[] args) {
        System.out.println("Example 1: got " + new Solution().isCousins(tree(1, 2, 3, 4), 4, 3) + "   expected false");
        System.out.println("Example 2: got " + new Solution().isCousins(tree(1, 2, 3, null, 4, null, 5), 5, 4) + "   expected true");
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

        class Pair{
            int depth;
            int parent;
            Pair(int d, int p){
                this.depth = d;
                this.parent = p;
            }
        }

        private Pair find(TreeNode root, int val, TreeNode parent, int currentDepth){
            if( root == null ){
                return null;
            }
            if( root.val == val ){
                return new Pair(currentDepth, parent == null ? -1 : parent.val );
            }
            Pair res = find(root.left, val, root, currentDepth + 1);
            if( res == null ){
                res = find(root.right, val, root, currentDepth + 1);
            }
            return res;
        }

        public boolean isCousins(TreeNode root, int x, int y) {
            Pair xpair = find(root, x, null, 0);
            Pair ypair = find(root, y, null, 0);
            if( xpair == null || ypair == null )
                return false;
            return xpair.depth == ypair.depth && xpair.parent != ypair.parent;
        }
    }
}
