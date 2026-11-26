package com.questions;

import java.util.*;

/*
 Runtime Complexity - O(n)
 Runtime - 27 ms
 Memory - 43.2 MB
*/
public class _133_Clone_Graph_01 {

    public static void main(String[] args) {
        // adjList = [[2,4],[1,3],[2,4],[1,3]]
        int[][] adj = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        Node[] nodes = new Node[adj.length + 1];
        for (int i = 1; i <= adj.length; i++) nodes[i] = new Node(i);
        for (int i = 1; i <= adj.length; i++) for (int j : adj[i - 1]) nodes[i].neighbors.add(nodes[j]);
        Node copy = new Solution().cloneGraph(nodes[1]);
        // read the clone back as an adjacency list
        Map<Integer, List<Integer>> out = new TreeMap<>();
        Deque<Node> queue = new ArrayDeque<>(List.of(copy));
        Set<Node> seen = new HashSet<>(List.of(copy));
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            List<Integer> vals = new ArrayList<>();
            for (Node m : n.neighbors) {
                vals.add(m.val);
                if (seen.add(m)) queue.add(m);
            }
            out.put(n.val, vals);
        }
        System.out.println("Example 1: got " + out.values() + " (new objects: " + (copy != nodes[1]) + ")   expected [[2, 4], [1, 3], [2, 4], [1, 3]] (new objects: true)");
    }

// Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    static class Solution {

        private Node process(Node node, HashMap<Integer, Node> map){
            if( node == null ){
                return null;
            }
            Node newNode = new Node(node.val);
            map.put(node.val, newNode);
            for(Node childNode : node.neighbors){
                if( map.containsKey( childNode.val ) ){
                    newNode.neighbors.add( map.get(childNode.val) );
                }
                else{
                    Node childClone = process( childNode, map );
                    newNode.neighbors.add( childClone );
                }
            }
            return newNode;
        }

        public Node cloneGraph(Node node) {
            return process(node, new HashMap<>());
        }
    }
}
