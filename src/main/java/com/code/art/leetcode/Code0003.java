package com.code.art.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述: 无重复字符的最长子串
 *
 * @author zhourao
 * @create 2021-07-05 7:11 下午
 */
public class Code0003 {

    public static int lengthOfLongestSubstring(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();

        List<Character> charList = new ArrayList<>();
        int max = 0;
        for (char c : chars) {
            int cIndex = charList.indexOf(c);
            if (cIndex > -1) {
                charList = charList.subList(cIndex + 1, charList.size());
            }
            charList.add(c);
            max = Math.max(max, charList.size());
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("aaaaaaaaa"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
