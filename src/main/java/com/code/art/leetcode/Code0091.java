package com.code.art.leetcode;

/**
 * 描述: 解码方法 https://leetcode-cn.com/problems/decode-ways/
 *
 * @author zhourao
 * @create 2021-08-20 11:15 下午
 */
public class Code0091 {

    public static int numDecodings(String s) {
        if (null == s || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < n; i++) {
            int parseInt = Integer.parseInt(s.substring(i - 1, i + 1));
            if ('0' == s.charAt(i) && parseInt > 26) return 0;

            if ('0' != s.charAt(i))
                dp[i + 1] += dp[i];

            if ('0' != s.charAt(i - 1) && parseInt <= 26)
                dp[i + 1] += dp[i - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("12345".substring(0, 2));

        System.out.println(numDecodings("06"));
        System.out.println(numDecodings("60"));
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("12"));
    }
}


