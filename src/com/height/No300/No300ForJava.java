package com.height.No300;

/**
 * No 300.
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 动态规划：用一个数组记录当前位置的上升最长子串
 * 公式：dp[i] 为小于i的所有j中，nums[j]<nums[i] 中 dp[i] = max(dp[j])+1
 */
public class No300ForJava {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) { //能延续上升的所有位置+1，然后取最大值
                    dp[i] = dp[j] + 1;
                    if (max < dp[i]) {
                        max = dp[i];
                    }
                }
            }
        }
        return max;
    }
}
