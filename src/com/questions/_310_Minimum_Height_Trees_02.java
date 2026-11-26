package com.questions;

import java.util.*;

/*
 Runtime Complexity - O(n)

Runtime - 95 ms
 Memory - 90.8 MB

*/
public class _310_Minimum_Height_Trees_02 {

    public static void main(String[] args) {
        _310_Minimum_Height_Trees_02 s = new _310_Minimum_Height_Trees_02();
        System.out.println("Example 1: got " + s.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}) + "   expected [1]");
        System.out.println("Example 2: got " + s.findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}) + "   expected [3, 4]");
    }

    private void insertInMap(int u, int v, Map<Integer, Set<Integer>> map){
        if( !map.containsKey(u) ){
            map.put(u, new HashSet<>());
        }
        map.get(u).add(v);
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for( int i=0 ; i<edges.length ; i++ ){
            insertInMap(edges[i][0], edges[i][1], map);
            insertInMap(edges[i][1], edges[i][0], map);
        }

        // array to store degree
        int deg[] = new int[n];
        // to store nodes with degree 1
        Queue<Integer> que = new LinkedList<>();
        for(Map.Entry<Integer, Set<Integer>> entry : map.entrySet()){
            deg[entry.getKey()] = entry.getValue().size();
            if( entry.getValue().size() == 1 ){
                que.add( entry.getKey() );
            }
        }

        Set<Integer> nodes = new HashSet<>();
        for(int i=0 ; i<n ; i++){
            nodes.add(i);
        }

        Queue<Integer> tmpque = new LinkedList<>();
        while( n > 2 ){
            n -= que.size();
            tmpque = new LinkedList<>();
            while( !que.isEmpty() ){
                int u = que.poll();
                nodes.remove(u);
                for(int v : map.get(u)){
                    deg[v]--;
                    if( deg[v] == 1 ){
                        tmpque.add(v);
                    }
                }
            }
            que = tmpque;
        }

        return new ArrayList<>(nodes);

    }
}
