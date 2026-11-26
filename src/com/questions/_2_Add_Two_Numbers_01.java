package com.questions;

import java.util.*;

/*
 Runtime Complexity - O(n)
 Runtime - 5 ms
 Memory - 48.2 MB
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
public class _2_Add_Two_Numbers_01 {

    public static void main(String[] args) {
        System.out.println("Example 1: got " + str(new Solution().addTwoNumbers(list(2, 4, 3), list(5, 6, 4))) + "   expected [7, 0, 8]");
        System.out.println("Example 2: got " + str(new Solution().addTwoNumbers(list(9, 9, 9, 9, 9, 9, 9), list(9, 9, 9, 9))) + "   expected [8, 9, 9, 9, 0, 0, 0, 1]");
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode result, last;
            result = last = null;
            int temp;
            while( l1 != null && l2 != null ){
                temp = l1.val + l2.val + carry;
                carry = temp > 9 ? 1 : 0;
                temp %= 10;
                if( result == null ){
                    result = new ListNode(temp);
                    last = result;
                }
                else{
                    last.next = new ListNode(temp);
                    last = last.next;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            for(ListNode l : Arrays.asList(l1, l2)){
                while( l != null ){
                    temp = carry + l.val;
                    carry = temp > 9 ? 1 : 0;
                    temp %= 10;
                    last.next = new ListNode(temp);
                    last = last.next;
                    l = l.next;
                }
            }
            if(carry > 0){
                last.next = new ListNode(carry);
                last = last.next;
            }
            return result;
        }
    }
}
