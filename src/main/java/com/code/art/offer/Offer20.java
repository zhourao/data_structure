package com.code.art.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述: 表示数值的字符串
 * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 *
 * @author zhourao
 * @create 2021-04-12 9:53 下午
 */
public class Offer20 {

    /**
     * 【题目】表示数值的字符串
     * 【题目说明】
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 【示例】
     *  字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
     */
    public static boolean isNumber(String s) {
        Map[] states = {
                new HashMap<Character, Integer>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
                new HashMap<Character, Integer>() {{ put('d', 2); put('.', 4); }},                           // 1.
                new HashMap<Character, Integer>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
                new HashMap<Character, Integer>() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
                new HashMap<Character, Integer>() {{ put('d', 3); }},                                        // 4.
                new HashMap<Character, Integer>() {{ put('s', 6); put('d', 7); }},                           // 5.
                new HashMap<Character, Integer>() {{ put('d', 7); }},                                        // 6.
                new HashMap<Character, Integer>() {{ put('d', 7); put(' ', 8); }},                           // 7.
                new HashMap<Character, Integer>() {{ put(' ', 8); }}                                         // 8.
        };
        int p = 0;
        char t;
        for(char c: s.toCharArray()) {
            if( c >= '0' && c <='9') t = 'd';
            else if(c == '+' || c == '-') t = 's';
            else if(c == 'e' || c == 'E')  t = 'e';
            else if(c == '.' || c == ' ') t  = c;
            else t = '?';
            if(!states[p].containsKey(t)) return false;
            p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }


    public static void main(String[] args) {
        System.out.println(isNumber("+100"));
        System.out.println(isNumber("+-100"));
    }
}