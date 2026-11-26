package com.questions;

import java.util.*;

/*
  Complexity - O( n * (v+e) )
 Runtime - 378 ms
 Memory - 50.7 MB
*/
public class _1462_Course_Schedule_IV_01 {

    public static void main(String[] args) {
        _1462_Course_Schedule_IV_01 s = new _1462_Course_Schedule_IV_01();
        System.out.println("Example 1: got " + s.checkIfPrerequisite(2, new int[][]{{1, 0}}, new int[][]{{0, 1}, {1, 0}}) + "   expected [false, true]");
        System.out.println("Example 2: got " + s.checkIfPrerequisite(3, new int[][]{{1, 2}, {1, 0}, {2, 0}}, new int[][]{{1, 0}, {1, 2}}) + "   expected [true, true]");
    }

    enum Color{
        white, gray, black;
    }

    void bfs(List<List<Integer>> graph, Color col[], int s, Map<Integer, Set<Integer>> map){
        init(col);

        Queue<Integer> que = new ArrayDeque<>();
        que.add(s);
        col[s] = Color.white;
        while( !que.isEmpty() ){
            int u = que.poll();
            col[u] = Color.gray;
            for(int v : graph.get(u)){
                if( col[v] == Color.white ){
                    que.add(v);
                    map.putIfAbsent(s, new HashSet<>());
                    map.get(s).add(v);
                }
            }
            col[u] = Color.black;
        }
    }

    void init(Color col[]){
        for(int i=0 ; i<col.length ; i++){
            col[i] = Color.white;
        }
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // initialization
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0 ; i<numCourses ; i++){
            graph.add( new LinkedList<>() );
        }
        for(int[] edge : prerequisites){
            graph.get(edge[0]).add(edge[1]);
        }

        Color col[] = new Color[numCourses];

        List<Boolean> result = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] query : queries){
            if( !map.containsKey(query[0]) ){
                bfs(graph, col, query[0], map);
            }
            boolean res;
            if( !map.containsKey(query[0]) ){
                res = false;
            }
            else{
                res = map.get(query[0]).contains(query[1]);
            }
            result.add( res );
        }

        return result;


    }
}
