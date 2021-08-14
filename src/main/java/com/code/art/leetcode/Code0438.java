package com.code.art.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述: 找到字符串中所有字母异位词 https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/
 *
 * @author zhourao
 * @create 2021-08-14 10:36 上午
 */
public class Code0438 {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        // 计算字符串p中各元素的出现次数
        int[] need = new int[26];
        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i) - 'a']++;
        }

        // 窗口区间为[left,right]
        int left = 0, right = -1;

        while (left < s.length()) {
            // 还有剩余元素未考察，且窗口内字符串长度小于字符串p的长度
            // 则扩大窗口右侧边界
            if (right + 1 < s.length() && right - left + 1 < p.length()) {
                right++;
            } else {
                // 右侧边界不能继续扩大或窗口内字符串长度等于字符串p的长度
                // 则缩小左侧边界
                left++;
            }

            // 当窗口内字符串长度等于字符串p的长度时，则判断其是不是字符串p的字母异位词子串
            if (right - left + 1 == p.length() && isAnagrams(s.substring(left, right + 1), need)) {
                res.add(left);
            }
        }
        return res;
    }

    // 判断当前子串是不是字符串p的字母异位词
    private static boolean isAnagrams(String window, int[] need) {
        // 计算窗口内字符串各元素的出现次数
        int[] windowFreq = new int[26];
        for (int i = 0; i < window.length(); i++) {
            windowFreq[window.charAt(i) - 'a']++;
        }
        // 比较窗口内各元素的出现次数和字符串p中各元素的出现次数是否一样
        // 如果都一样，则说明窗口内的字符串是字符串p的字母异位词子串
        // 如果不一样，则说明不是其子串
        for (int j = 0; j < 26; j++) {
            if (windowFreq[j] != need[j]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc").size());
    }
}