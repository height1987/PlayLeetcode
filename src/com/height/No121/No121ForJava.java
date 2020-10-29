package com.height.No121;

import java.util.ArrayList;
import java.util.List;

/**
 * 121.  Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * 解题思路：
 * 利用动态规划，记录当前位置的最小值和最小值的位置，然后找出当前位置和最小值的差值，
 * 然后找到这个差值的最大值。时间复杂度O(n) ,空间复杂度O(n)
 */
public class No121ForJava {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minValue = prices[0];
        int maxPro = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] - minValue > maxPro){
                maxPro = prices[i] - minValue;
            }
            if(prices[i] < minValue){
                minValue = prices[i];
            }
        }
        return maxPro;
    }
}
