package com.questions;

import java.util.*;

/*

 Runtime - 1398 ms
 Memory - 42.5 MB
*/
public class _32_Longest_Valid_Parentheses_01 {

    public static void main(String[] args) {
        _32_Longest_Valid_Parentheses_01 s = new _32_Longest_Valid_Parentheses_01();
        System.out.println("Example 1: got " + s.longestValidParentheses("(()") + "   expected 2");
        System.out.println("Example 2: got " + s.longestValidParentheses(")()())") + "   expected 4");
    }
    private boolean checkIfValid(String s){
        Deque<Character> que = new LinkedList<>();
        for(char c : s.toCharArray()){
            if( c == '(' ){
                que.addFirst(c);
            }
            else{
                // closing brace
                if( que.isEmpty() ){
                    return false;
                }
                que.pollFirst();
            }
        }
        return que.isEmpty();
    }

    public int longestValidParentheses(String s) {
        if( s.length() == 0 || s.length() == 1){
            return 0;
        }
        int open = 0, close = 0;
        int maxLength = 0;
        for(int i=0 ; i<s.length()-1 ; i++){
            open = close = 0;
            if( s.charAt(i) == '(' ){
                open++;
            }
            else{
                close++;
            }
            for(int j=i+1 ; j<s.length() ; j++){
                if( s.charAt(j) == '(' ){
                    open++;
                }
                else{
                    close++;
                }
                if( close > open ){
                    break;
                }
                else if ( close < open ){
                    continue;
                }
                else{
                    // check for validity
                    if( checkIfValid(s.substring(i, j+1)) && maxLength < j-i+1){
                        maxLength = j-i+1;
                    }
                }
            }
        }
        return maxLength;
    }
}
