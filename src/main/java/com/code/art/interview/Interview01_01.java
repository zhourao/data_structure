package com.code.art.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述: 判定字符是否唯一
 * https://leetcode-cn.com/problems/is-unique-lcci/
 *
 * @author zhourao
 * @create 2021年4月21日 07:10:04
 */
public class Interview01_01 {

    /**
     * 【题目】判定字符是否唯一
     * 【题目说明】
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
     *【示例1】
     * 输入: s = "leetcode"
     * 输出: false
     *【示例2】
     * 输入: s = "abc"
     * 输出: true
     */
    public static boolean isUnique(String astr) {
        Set<Character> s = new HashSet<>();
        for (int i = 0; i < astr.length(); i++) {
            if(s.contains(astr.charAt(i)))
                return false;
            s.add(astr.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("abc"));
        System.out.println(isUnique("leetcode"));
    }
}
