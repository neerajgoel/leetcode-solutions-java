package com.questions;

import java.util.*;

/*
 Runtime Complexity - O(E*K)

 Runtime - 4 ms
 Memory - 43.8 MB

*/
public class _787_Cheapest_Flights_Within_K_Stops_02 {

    public static void main(String[] args) {
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        System.out.println("Example 1: got " + findCheapestPrice(4, flights, 0, 3, 1) + "   expected 700");
        System.out.println("Example 2: got " + findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1) + "   expected 200");
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int d[] = new int[n];
        int temp[] = new int[n];
        for(int i=0 ; i<n ; i++){
            d[i] = Integer.MAX_VALUE;
        }
        d[src] = 0;

        for(int i=0 ; i<=k ; i++){
            for(int j=0 ; j<n ; j++){
                temp[j] = d[j];
            }
            System.out.print("d : ");
            Arrays.stream(d).forEach(c -> System.out.print(c + "\t"));
            System.out.println();
            for(int j=0 ; j<flights.length ; j++){
                int u = flights[j][0];
                int v = flights[j][1];
                int w = flights[j][2];
                if( d[u] != Integer.MAX_VALUE && d[v] > d[u] + w && d[u] + w < temp[v]){
                    temp[v] = d[u] + w;
                }
            }
            System.out.print("te,p : ");
            Arrays.stream(temp).forEach(c -> System.out.print(c + "\t"));
            System.out.println();
            for(int j=0 ; j<n ; j++){
                d[j] = temp[j];
            }
        }

        return d[dst] == Integer.MAX_VALUE ? -1 : d[dst];
    }


}
