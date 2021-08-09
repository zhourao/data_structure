package com.code.art.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:盛最多水的容器 https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author zhourao
 * @create 2021-08-09 10:30 下午
 */
public class Code0011 {

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            ans = height[l] < height[r] ? Math.max(ans, (r - l) * height[l++]) : Math.max(ans, (r - l) * height[r--]);
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}