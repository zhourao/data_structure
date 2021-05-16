package com.code.art.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 描述: 判定是否互为字符重排
 * https://leetcode-cn.com/problems/check-permutation-lcci/
 *
 * @author zhourao
 * @create 2021年4月21日 07:10:04
 */
public class Interview01_02 {

    /**
     * 【题目】判定是否互为字符重排
     * 【题目说明】
     * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     *【示例1】
     * 输入: s1 = "abc", s2 = "bca"
     * 输出: true
     *【示例2】
     * 输入: s1 = "abc", s2 = "bad"
     * 输出: false
     */
    public static boolean CheckPermutation(String s1, String s2) {
        Map<Character, Integer> m1= new HashMap<>();
        for (int i = 0; i < s1.length(); i++)
            m1.put(s1.charAt(i), m1.containsKey(s1.charAt(i)) ? m1.get(s1.charAt(i)) + 1 : 1);

        for (int i = 0; i < s2.length(); i++) {
            if(!m1.containsKey(s2.charAt(i))) return false;
            int cnt = m1.get(s2.charAt(i)) - 1;
            if(cnt <= 0) m1.remove(s2.charAt(i));
            else m1.put(s2.charAt(i), cnt) ;
        }
        return m1.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(CheckPermutation("abc","bca"));
        System.out.println(CheckPermutation("abc","bad"));
    }
}
