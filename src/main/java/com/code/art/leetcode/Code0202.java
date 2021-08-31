package com.code.art.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 描述: 快乐数 https://leetcode-cn.com/problems/happy-number/
 *
 * @author zhourao
 * @create 2021-08-25 5:45 下午
 */
public class Code0202 {

    Set<Integer> sets = new HashSet<Integer>();

    public boolean isHappy(int n) {
        if (sets.contains(n)) return false;
        sets.add(n);
        int a = 0;
        while (n > 0) {
            a += (int) Math.pow(n % 10, 2);
            n = n / 10;
        }
        if (a == 1) return true;
        return isHappy(a);
    }

    public static void main(String[] args) {
        Code0202 code0202 = new Code0202();
        System.out.println(code0202.isHappy(2));
        System.out.println(code0202.isHappy(4));
    }
}
