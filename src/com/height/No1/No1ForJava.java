package com.height.No1;


import java.util.HashMap;

/** 1. 两数之和
 * https://leetcode-cn.com/classic/problems/two-sum/description/
 */
public class No1ForJava {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 1){
            return new int[0];
        }
        HashMap<Integer,Integer> numMap = new HashMap<Integer,Integer>(nums.length);

        for(int i = 0 ; i < nums.length ;i ++){
            numMap.put(nums[i],i);
        }
        for(int i = 0 ; i < nums.length ;i ++){
            int toFindKey = target - nums[i];
            Integer place = numMap.getOrDefault(toFindKey, -1);
            if(place >= 0 && place != i){
                return new int[]{i,place};
            }
        }
        return new int[0];
    }
}
