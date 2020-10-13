package com.height.No53;

/**
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *     https://leetcode-cn.com/problems/maximum-subarray/
 *     示例:
 *     输入: [-2,1,-3,4,-1,2,1,-5,4]
 *     输出: 6
 *     解释:连续子数组[4,-1,2,1] 的和最大，为6。
 *     进阶: 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 *     解决思路：
 *     问题可以转化为:
 *     以j作为结尾的子串中，最大的子串和是：
 *     sum[0,j]-min(0,min(sum[0,0],...,sum[0,j-1]))
 *     解释：是0~j位置的子串，减去 在j位置之前的且最小的且小于0的前缀子串和
 *
 */
public class No53ForJava {
    public int maxSubArray(int[] nums) {
        if(nums == null){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }

        int [] preSum = new int[nums.length];
        preSum[0] = nums[0];
        int maxSum = preSum[0];
        for(int i = 1 ; i < nums.length; i++){
            preSum[i] = nums[i] + preSum[i-1];

            if(preSum[i] > maxSum){
                maxSum = preSum[i];
            }
        }
        int minusSum = 0;
        int [] minusPreSum = new int[nums.length];

        for(int i = 0 ; i < nums.length; i++){
            if(preSum[i] < 0 && preSum[i] < minusSum){
                minusSum = preSum[i];
                minusPreSum[i] = preSum[i];
            }else{
                minusPreSum[i] = minusSum;
            }
        }
        int minMax = preSum[0];

        for(int i = 1 ; i < nums.length; i++){
            int minValue = preSum[i] - minusPreSum[i - 1];
            if(minValue > minMax){
                minMax = minValue;
            }
        }
        return minMax;

    }

}
