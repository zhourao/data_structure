package com.code.art.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述: 罗马数字转整数 https://leetcode-cn.com/problems/roman-to-integer/
 *
 * @author zhourao
 * @create 2021-09-06 2:56 下午
 */
public class Code0013 {


    Map<Character, Integer> table = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = table.get(s.charAt(i));
            ans += i < n - 1 && value < table.get(s.charAt(i + 1)) ? -1 * value : value;
        }
        return ans;
    }
}
