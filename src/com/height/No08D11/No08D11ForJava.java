package com.height.No08D11;

/**
 * https://leetcode-cn.com/problems/coin-lcci/
 * 思路 背包问题
 */
public class No08D11ForJava {
    static final int MOD = 1000000007;
    int[] coins = {25, 10, 5, 1};

    public int waysToChange(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int c = 0; c < 4; ++c) {
            int coin = coins[c];
            for (int i = coin; i <= n; ++i) {
                f[i] = (f[i] + f[i - coin]) % MOD;
            }
        }
        return f[n];
    }

}
