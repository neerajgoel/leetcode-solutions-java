package com.questions;

import java.util.*;

/**
 * O(n) - RunTime Complexity
 * Runtime - 1743 ms
 * Memory - 123.2 MB
 */
public class _295_FindMedianFromDataStream_01 {

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        double first = mf.findMedian();
        mf.addNum(3);
        double second = mf.findMedian();
        System.out.println("Example 1: got " + "[" + first + ", " + second + "]" + "   expected [1.5, 2.0]");
    }

    static class MedianFinder {

        List<Integer> list;

        public MedianFinder() {
            list = new ArrayList<>(50001);
        }

        private int findPos(int num){
            for(int i=0 ; i<list.size() ; i++){
                if( list.get(i) > num )
                    return i;
            }
            return -1;
        }

        public void addNum(int num) {
            int post = findPos(num);
            if( post == -1 )
                list.add(num);
            else
                list.add(post, num);
        }

        public double findMedian() {
            System.out.println(list);
            if( list.size() % 2 == 0 ){
                // even size
                double res = list.get( (list.size()/2) - 1 );
                return (res + list.get( list.size()/2 ) )  / 2;
            }
            return list.get( list.size()/2 );
        }
    }

}
