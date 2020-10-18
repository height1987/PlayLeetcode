package com.height.No118;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * https://leetcode-cn.com/problems/pascals-triangle/
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 解决思路
 * 问题可以转化为:
 * 主要是边界条件的处理，第一和第二层都是1，优先处理，然后处理后面每一层的第一个和最后一个，然后处理中间的
 */
public class No118ForJava {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1) {
            return res;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> dp = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (i < 2) {
                    dp.add(1);
                } else {
                    if (j == 0 || j == i) {
                        dp.add(1);
                    } else {
                        dp.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
                    }
                }
            }
            res.add(dp);
        }
        return res;
    }

}
