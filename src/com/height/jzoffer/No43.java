package com.height.jzoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 43. 1～n 整数中 1 出现的次数
 * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 * <p>
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 */
public class No43 {
    public int countDigitOne(int n) {
        List<Integer> bitNum = getBitNum(n);
        int count = 0;
        for (int i = 0; i < bitNum.size(); i++) {
            count = count + getOneCount(bitNum, i);
        }
        return count;
    }

    public int getOneCount(List<Integer> bitNum, int index) {
        int count = 1;
        for (int i = 0; i < bitNum.size(); i++) {
            if (i == index) {
                continue;
            }

                count = count * (bitNum.get(i) + 1);

        }
        return count;

    }

    public List<Integer> getBitNum(int n) {
        List<Integer> bitNum = new ArrayList<>();

        while (n > 0) {
            bitNum.add(n % 10);
            n = n / 10;
        }
        return bitNum;
    }
}