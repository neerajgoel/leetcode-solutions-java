package com.questions;

import java.util.*;

/* 
 -- In-place algorithm
 Runtime Complexity - O(n)
 Runtime - 0 ms
 Memory - 42.1 MB
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
public class _206_Reverse_Linked_ListList_01 {

    public static void main(String[] args) {
        System.out.println("Example 1: got " + str(new Solution().reverseList(list(1, 2, 3, 4, 5))) + "   expected [5, 4, 3, 2, 1]");
        System.out.println("Example 2: got " + str(new Solution().reverseList(list(1, 2))) + "   expected [2, 1]");
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

        private Pair reverseListIntrl(ListNode head) {
            if( head == null ){
                return null;
            }
            Pair reversedList = reverseListIntrl( head.next );
            head.next = null;
            if( reversedList == null ){
                return new Pair(head, head);
            }
            reversedList.second.next = head;
            return new Pair( reversedList.first, head);
        }

        public ListNode reverseList(ListNode head) {
            Pair resultPair = reverseListIntrl( head );
            if( resultPair == null ){
                return null;
            }
            return resultPair.first;
        }

    }
}
