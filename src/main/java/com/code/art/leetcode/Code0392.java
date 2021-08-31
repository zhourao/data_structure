package com.code.art.leetcode;

/**
 * 描述:判断子序列 https://leetcode-cn.com/problems/is-subsequence/
 *
 * @author zhourao
 * @create 2021-08-18 10:07 上午
 */
public class Code0392 {

    public static boolean isSubsequence(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int i = 0;
        int j = 0;
        while (i < sChar.length && j < tChar.length) {
            if (sChar[i] == tChar[j]) {
                i++;
            }
            j++;
        }
        return i == sChar.length;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }
}
