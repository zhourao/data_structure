package com.code.art.leetcode;

/**
 * 描述: 数字范围按位与 https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 *
 * @author zhourao
 * @create 2021-08-25 4:29 下午
 */
public class Code0201 {

    public static int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        // 找到公共前缀
        while (left < right) {
            left >>= 1;
            right >>= 1;
            ++shift;
        }
        return left << shift;
    }

    public static void main(String[] args) {

    }
}
