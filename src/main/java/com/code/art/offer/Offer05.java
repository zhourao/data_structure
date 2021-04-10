package com.code.art.offer;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

/**
 * 描述: 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 *
 * @author zhourao
 * @create 2021-04-10 9:28 上午
 */
public class Offer05 {

    /**
     * 【题目】替换空格
     * 【题目说明】
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * 【示例】
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     */
    public static String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        for (Character c : s.toCharArray()) {
            if (c == ' ') sb.append("%20");
            else sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
}