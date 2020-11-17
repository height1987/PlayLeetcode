package com.height.No88;

/**
 * 88. 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 思路：
 * 双指针法：
 * 从num1的后面开始进行对比
 *
 */
public class No88ForJava {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2 == null || nums2.length==0){
            return;
        }
        int pos1 = m-1;
        int pos2 = n-1;
        int pos1End = m+n-1;
        while(pos1 > -1 || pos2 > -1){
            if(pos1 < 0){
                nums1[pos1End] = nums2[pos2];
                pos2--;
                pos1End -- ;
                continue;
            }
            if(pos2 < 0){
                break;
            }
            if(nums1[pos1] > nums2[pos2]){
                nums1[pos1End] = nums1[pos1];
                pos1--;
            }else{
                nums1[pos1End] = nums2[pos2];
                pos2--;
            }
            pos1End -- ;
        }

    }

}
