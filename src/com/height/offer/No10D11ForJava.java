package com.height.offer;

import java.util.Arrays;

/**
 * 面试题 10.11. 峰与谷
 * https://leetcode-cn.com/problems/peaks-and-valleys-lcci/
 * 在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。例如，在数组{5, 8, 4, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。
 * <p>
 * 思路：题目没理解，先排序再 偶数位和奇数位换一下，就是这么排
 * 奇数位发现大于偶数位，则交换
 * 偶数位发现小于奇数位，则交换
 */
public class No10D11ForJava {
    public void wiggleSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) {
                if (nums[i] < nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            } else {
                if (nums[i] > nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            }
        }


    }

    private void swap(int[] nums, int i, int i1) {
        int tmp = nums[i];
        nums[i] = nums[i - 1];
        nums[i - 1] = tmp;
    }


}
