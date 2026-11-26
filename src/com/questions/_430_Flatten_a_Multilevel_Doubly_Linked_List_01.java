package com.questions;

import java.util.*;

/*

Runtime - 1 ms
Memory - 40.3 MB
*/
public class _430_Flatten_a_Multilevel_Doubly_Linked_List_01 {

    public static void main(String[] args) {
        // head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
        Node[] n = new Node[13];
        for (int i = 1; i <= 12; i++) {
            n[i] = new Node();
            n[i].val = i;
        }
        int[][] levels = {{1, 6}, {7, 10}, {11, 12}};
        for (int[] lv : levels) {
            for (int i = lv[0]; i < lv[1]; i++) {
                n[i].next = n[i + 1];
                n[i + 1].prev = n[i];
            }
        }
        n[3].child = n[7];
        n[8].child = n[11];
        Node head = new _430_Flatten_a_Multilevel_Doubly_Linked_List_01().flatten(n[1]);
        List<Integer> out = new ArrayList<>();
        for (Node x = head; x != null; x = x.next) out.add(x.val);
        System.out.println("Example 1: got " + out + "   expected [1, 2, 3, 7, 8, 11, 12, 9, 10, 4, 5, 6]");
    }

// Definition for a Node.
static class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};


    public Node flatten(Node head) {
        if( head == null ){
            return null;
        }
        if( head.child != null ){
            // flatten child
            Node flattndChild  = flatten( head.child );
            if( head.next == null ){
                head.next = flattndChild;
                flattndChild.prev = head;
                head.child = null;
            }
            else{
                Node nextNode = head.next;
                head.next = flattndChild;
                flattndChild.prev = head;
                head.child = null;
                Node lastNode = null;
                while( flattndChild != null ){
                    lastNode = flattndChild;
                    flattndChild = flattndChild.next;
                }
                lastNode.next = nextNode;
                nextNode.prev = lastNode;
            }
        }
        flatten(head.next);
        return head;
    }
}
