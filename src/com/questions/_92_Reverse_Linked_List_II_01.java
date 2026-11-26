package com.questions;

import java.util.*;

/* 
 -- In-place algorithm
 Runtime Complexity - O(n)
 Runtime - 0 ms
 Memory - 39.8 MB
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class _92_Reverse_Linked_List_II_01 {

    public static void main(String[] args) {
        System.out.println("Example 1: got " + str(new Solution().reverseBetween(list(1, 2, 3, 4, 5), 2, 4)) + "   expected [1, 4, 3, 2, 5]");
        System.out.println("Example 2: got " + str(new Solution().reverseBetween(list(5), 1, 1)) + "   expected [5]");
    }

    // LeetCode's ListNode, plus helpers to build and print lists
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static ListNode list(int... values) {
        ListNode dummy = new ListNode(0), tail = dummy;
        for (int v : values) {
            tail.next = new ListNode(v);
            tail = tail.next;
        }
        return dummy.next;
    }

    static String str(ListNode node) {
        List<Integer> out = new ArrayList<>();
        for (; node != null; node = node.next) out.add(node.val);
        return out.toString();
    }

    static class Solution {

        class Pair{
            ListNode first, second;
            Pair(ListNode _f, ListNode _s){
                this.first = _f;
                this.second = _s;
            }
        }

        private Pair reverseListIntrl(ListNode head, int left, int right, int curr) {
            if( head == null ){
                return null;
            }
            if( curr >= right ){
                return new Pair(head, head);
            }
            Pair reversedList = reverseListIntrl( head.next, left, right, curr + 1 );
            if( reversedList == null ){
                head.next = null;
                return new Pair(head, head);
            }
            if( left <= curr ){
                head.next = reversedList.second.next;
                reversedList.second.next = head;
                return new Pair( reversedList.first, head);
            }
            head.next = reversedList.first;
            return new Pair( head, null);
        }

        public ListNode reverseBetween(ListNode head, int left, int right) {
            if( head == null ){
                return null;
            }
            Pair resultPair = reverseListIntrl(head, left, right, 1);
            return resultPair.first;
        }
    }
}
