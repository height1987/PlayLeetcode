package com.height.No16D24;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *     面试题 16.24. 数对和
 *     https://leetcode-cn.com/problems/pairs-with-sum-lcci/
 *     示例:
 *     设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
 *
 *     示例 1:
 *     输入: nums = [5,6,5], target = 11
 *     输出: [[5,6]]
 *
 *
 *     解决思路：
 *     问题可以转化为:
 *     以j作为结尾的子串中，最大的子串和是：
 *     sum[0,j]-min(0,min(sum[0,0],...,sum[0,j-1]))
 *     解释：是0~j位置的子串，减去 在j位置之前的且最小的且小于0的前缀子串和
 *
 */
public class No16D24ForJava {
    public int pairSums(int[] nums) {
        if(nums == null){
            return 0;
        }
        Map<Integer, Set<Integer>>  res= new HashMap<>();
    }

}
