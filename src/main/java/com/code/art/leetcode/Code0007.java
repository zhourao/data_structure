package com.code.art.leetcode;

/**
 * 描述:
 *
 * @author zhourao
 * @create 2021-07-06 5:25 下午
 */
public class Code0007 {

    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(reverse(120));
    }
}
