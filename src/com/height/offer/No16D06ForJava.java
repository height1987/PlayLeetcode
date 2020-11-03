package com.height.offer;

import java.util.Arrays;

/**
 * 面试题 16.06. 最小差
 * https://leetcode-cn.com/problems/smallest-difference-lcci/
 * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 *
 * 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
 * 输出： 3，即数值对(11, 8)
 *
 * 思路：先排序，再双指针法
 *
 */
public class No16D06ForJava {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while(i < a.length && j < b.length){
            min = Math.min(min, Math.abs((long)a[i] - (long)b[j]));
            if(a[i] < b[j]){
                i++;
            }else{
                j++;
            }
        }
        return (int)min;
    }
}
