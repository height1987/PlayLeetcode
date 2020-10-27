package com.height.No121;

/**
 * 121.  Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 *
 * 解题思路：
 * 利用动态规划，记录当前位置的最小值和最小值的位置，然后找出当前位置和最小值的差值，
 * 然后找到这个差值的最大值。时间复杂度O(n) ,空间复杂度O(n)
 *
 *
 */
public class No121ForJava {
    public int maxProfit(int[] prices) {

    }
}
class Content{
    public int minIndex;
    public int minValue;
    public int maxPro;
}