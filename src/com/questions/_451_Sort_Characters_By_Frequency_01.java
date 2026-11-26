package com.questions;

import java.util.*;

/*
O(n) - time complexity
Runtime - 28 ms
Memory - 54.9 MB
*/
public class _451_Sort_Characters_By_Frequency_01 {

    public static void main(String[] args) {
        System.out.println("Example 1: got " + new Solution().frequencySort("tree") + "   expected eert (eetr is also valid)");
        System.out.println("Example 2: got " + new Solution().frequencySort("Aabb") + "   expected bbAa (bbaA is also valid)");
    }

    static class Solution {
        public String frequencySort(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for( char c : s.toCharArray()){
                if( !map.containsKey(c) ){
                    map.put(c, 0);
                }
                map.put(c, map.get(c) + 1);
            }

            List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>(){
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2){
                    return -1 * (o1.getValue() - o2.getValue());
                }
            });

            Collections.sort(list, (o1, o2) -> -1 * (o1.getValue() - o2.getValue()));

            StringBuilder sb = new StringBuilder();
            int x;
            for(Map.Entry<Character, Integer> entry : list){
                x = entry.getValue();
                while(x-- > 0){
                    sb.append(entry.getKey());
                }
            }
            return sb.toString();
        }
    }

}
