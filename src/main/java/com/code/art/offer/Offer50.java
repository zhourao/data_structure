package com.code.art.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:第一个只出现一次的字符
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 *
 * @author zhourao
 * @create 2021-04-16 10:01 上午
 */
public class Offer50 {

    /**
     * 【题目】第一个只出现一次的字符
     * 【题目说明】
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     * 【示例1】
     * s = "abaccdeff"
     * 返回 "b"
     * s = ""
     * 返回 " "
     */
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc)
            dic.put(c, !dic.containsKey(c));
        for (char c : sc)
            if (dic.get(c)) return c;
        return ' ';
    }

    public static void main(String[] args) {

    }
}