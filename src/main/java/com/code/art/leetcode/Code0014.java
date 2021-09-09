package com.code.art.leetcode;

/**
 * 描述: 最长公共前缀 https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @author zhourao
 * @create 2021-09-06 5:26 下午
 */
public class Code0014 {

    public static String longestCommonPrefix(String[] strs) {
        int j = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            j = getSamplePrefix(strs[0], j, strs[i]);
            if (j == 0) return "";
        }
        return strs[0].substring(0, j);
    }

    private static int getSamplePrefix(String str, int j, String anotherStr) {
        for (int i = 0; i < j; i++)
            if (i >= anotherStr.length() || str.charAt(i) != anotherStr.charAt(i))
                return i;
        return j;
    }

    public static void main(String[] args) {
        String[] strs = new String[] {"abc","abc","dbc"};

        System.out.println(longestCommonPrefix(strs));
    }
}
