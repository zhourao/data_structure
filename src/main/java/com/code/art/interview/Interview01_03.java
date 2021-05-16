package com.code.art.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述: URL化
 * https://leetcode-cn.com/problems/string-to-url-lcci/
 *
 * @author zhourao
 * @create 2021年4月21日 07:10:04
 */
public class Interview01_03 {

    /**
     * 【题目】URL化
     * 【题目说明】
     * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
     * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
     *【示例1】
     * 输入："Mr John Smith    ", 13
     * 输出："Mr%20John%20Smith"
     *【示例2】
     * 输入："               ", 5
     * 输出："%20%20%20%20%20"
     */
    public static String replaceSpaces(String S, int length) {
        char[] res =new char[length * 3];
        int fillIndex = 0;
        for (int i = 0; i < S.length(); i++) {
            if(fillIndex >= res.length || fillIndex >= S.length())
                break;
            if(S.charAt(i) == ' ' && fillIndex <= res.length -3) {
                res[fillIndex++] = '%';
                res[fillIndex++] = '2';
                res[fillIndex++] = '0';
            } else
                res[fillIndex++] =S.charAt(i);

        }
        return String.valueOf(res,0, fillIndex);
    }

    public static void main(String[] args) {
        System.out.println(replaceSpaces("Mr John Smith    ",13));
        System.out.println(replaceSpaces("               ",5));
        System.out.println(replaceSpaces("ds sdfs afs sdfa dfssf asdf             ",27));
    }
}
