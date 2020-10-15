package com.height.No63;


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
 * 
 */
public class No63ForJava {
    public static int uniquePathsWithObstacles(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j] == 1 ? 0 :1;
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = (grid[i][j] == 1 ? 0 : dp[i][j - 1]);
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = (grid[i][j] == 1 ? 0 : dp[i - 1][j]);
                    continue;
                }
                dp[i][j] = (grid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1]);
            }
        }
        return dp[row - 1][col - 1];
    }

}

