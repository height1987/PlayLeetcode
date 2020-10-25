package com.height.No16D24;

import java.util.*;

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
 *
 *
 */
public class No16D24ForJava {
    public static List<List<Integer>> pairSums(int[] nums, int target) {
        if(nums == null){
            return new ArrayList<>();
        }
        List<List<Integer>>  res= new ArrayList<>();
        Map<Integer, Integer>  resTmp= new HashMap<>();
        for(int i = 0 ; i < nums.length;i++) {
            Integer currentKey = target - nums[i];
            if(resTmp.containsKey(currentKey)){
                Integer oneResCount = resTmp.get(currentKey);
                res.add(getOneRes(nums[i], currentKey));
                if(oneResCount  == 1){
                    resTmp.remove(currentKey);
                }else{
                    resTmp.put(currentKey,oneResCount-1);
                }
            }else{
                resTmp.put(nums[i],resTmp.getOrDefault(nums[i],0)+1);
            }
        }
        return res;
    }

    private static List<Integer> getOneRes(int one, Integer two) {
        List<Integer> res = new ArrayList<>();
        res.add(one);
        res.add(two);
        return res;
    }
}