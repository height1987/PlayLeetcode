package com.height.No70;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 解决思路
 * 问题可以转化为:
 * 用一个长度为n的数组记录到每个台阶的方法种树
 * 到i个台阶的方式是 从i-1跨1步，或者从i-2跨2步
 * 则迭代公式出来了 dp[i] = dp[i - 1] + dp[i - 2]
 * 然后处理下边界条件
 */
public class No70ForJava {
    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

}
