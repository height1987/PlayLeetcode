package com.height.No238;

/**
 *  238. 除自身以外数组的乘积
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 */
public class No238ForJava {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{0};
        }
        int sum = 1;
        int zeroCount = 0;
        int lastZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                sum = sum * nums[i];
            }
            if (nums[i] == 0) {
                zeroCount++;
                lastZeroIndex = i;
            }
        }
        int[] res = new int[nums.length];
        if (zeroCount > 1) {
            return res;
        }
        if (zeroCount == 1) {
            res[lastZeroIndex] = (int) sum;
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = sum / nums[i];
        }
        return res;
    }
}
