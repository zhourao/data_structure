package com.code.art.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:三数之和 https://leetcode-cn.com/problems/3sum/
 *
 * @author zhourao
 * @create 2021-08-09 12:00 上午
 */
public class Code0015 {

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        //枚举a
        for (int first = 0; first < n; first++) {
            //需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            //c对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];

            //枚举b
            for (int second = first + 1; second < n; second++) {
                //需要和上一次枚举的数不同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                //需要保证b的指针在c的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }

                //如果指针重合，随着b后续的增加
                //就不会满足 a+b+c=0 并且 b < c的c了，可以退出循环
                if (second == third) {
                    break;
                }

                if(nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}