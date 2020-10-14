package com.height.No62;


import java.util.HashMap;

/**
 * 62. 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 创建mxn大小的数组，dp[i][j]记录到i,j位置的路径个数。
 * <p>
 * 1.第一行和第一列位置都是只有1种走法
 * 2.除此之外的位置可以从他的左面单元和上面到达，所以到当前位置的路径是到达左面单元和到达上面单元的路径之和
 * 即dp[i][j] = dp[i-1][j]+dp[i][j-1]
 */
public class No62ForJava {
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        int[][] countNum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    countNum[i][j] = 1;
                    continue;
                }
                countNum[i][j] = countNum[i - 1][j] + countNum[i][j - 1];
            }
        }
        return countNum[m - 1][n - 1];
    }
}

