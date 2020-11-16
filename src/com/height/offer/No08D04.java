package com.height.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.04. 幂集
 * https://leetcode-cn.com/problems/power-set-lcci/
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 不断追加
 *
 */
public class No08D04 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int num:nums){
            List<List<Integer>> current = new ArrayList<>();
            for(int i = 0 ; i< res.size();i++){
                ArrayList<Integer> currentOne = new ArrayList<>(res.get(i));
                currentOne.add(num);
                current.add(currentOne);
            }
            res.addAll(current);
        }
        return res;
    }

    public List<List<Integer>> subsetsB(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            for (int i = 0, j = res.size(); i < j; i++) {
                List<Integer> one = new ArrayList<>(res.get(i));
                one.add(num);
                res.add(one);
            }
        }
        return res;
    }
}
