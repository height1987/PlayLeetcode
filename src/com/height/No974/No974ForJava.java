package com.height.No974;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * 974. 和可被 K 整除的子数组
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 * 题目：给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * 解题思路：
 * 前缀和的模相同的个数，就是能被K整除的子数组的个数
 * 1.先算出前缀和的摸
 * 2.通过hashmap获取摸相同的个数
 */

public class No974ForJava {
    public static int subarraysDivByK(int[] array, int num) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (num == 0) {
            return 0;
        }
        int newK = num < 0 ? (num * -1) : num;

        Map<Integer, Integer> count = new HashMap<Integer, Integer>();

        count.put(0, 1);
        int preSum = 0;
        for (int i = 0; i < array.length; i++) {
            int mokNow = ((array[i] + preSum) % newK + newK) % newK;
            count.put(mokNow, count.getOrDefault(mokNow, 0) + 1);
            preSum += array[i];
        }
        int allCount = 0;
        for (Map.Entry<Integer, Integer> key : count.entrySet()) {
            allCount += (key.getValue() * (key.getValue() - 1) / 2);
        }
        return allCount;
    }


}
