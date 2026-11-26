package com.questions;

import java.util.*;

/*
  Complexity - O( n )
  -- can be done O(k)
 Runtime - 0 ms
 Memory - 41.8 MB
*/
public class _230_Kth_Smallest_Element_in_a_BST_01 {

    public static void main(String[] args) {
        _230_Kth_Smallest_Element_in_a_BST_01 s = new _230_Kth_Smallest_Element_in_a_BST_01();
        System.out.println("Example 1: got " + s.kthSmallest(tree(3, 1, 4, null, 2), 1) + "   expected 1");
        System.out.println("Example 2: got " + s.kthSmallest(tree(5, 3, 6, 2, 4, null, null, 1), 3) + "   expected 3");
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


    class Result{
        int count = 0;
        int val;
        void set(int v, int k){
            if( count + 1 > k ){
                return;
            }
            count++;
            this.val = v;
        }
    }

    private void find(TreeNode node, int k, Result result){
        if( node == null ){
            return;
        }
        find(node.left, k, result);
        result.set(node.val, k);
        find(node.right, k, result);
    }

    public int kthSmallest(TreeNode root, int k) {
        Result result = new Result();
        find(root, k, result);
        return result.val;
    }

}
