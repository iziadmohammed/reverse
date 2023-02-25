package com.stc;

import java.util.Stack;

public class Main {
    public static String reverse(String s) {
        int n = s.length();
        Stack<Integer> opened = new Stack<>();
        int[] pair = new int[n];
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(')
                opened.push(i);
            if (s.charAt(i) == ')') {
                int j = opened.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        int  d = 1;
        for (int i = 0; i < n; i += d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                if(d>0)  sb.append(s.charAt(i));
                i = pair[i];
                d = -d;
                if(d>0)  sb.append(s.charAt(i));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
      String value = "abd(jnb)asdf";
        System.out.println(value);
        System.out.println(reverse(value));
    }
}