package com.height.No387;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * 题目：给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 解题思路：先通过hashmap算出每个char出现的次数，然后循环取出次数为1的最小的index
 */

public class No387ForJava {

    public int firstUniqChar(String s) {
        if (s == null || "".equals(s)) {
            return -1;
        }
        Map<String, Integer> charCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String thisChar = String.valueOf(s.charAt(i));
            if (charCount.containsKey(thisChar)) {
                if(!(charCount.get(thisChar).equals(-1))){
                    charCount.put(thisChar, -1);
                }
            } else {
                charCount.put(thisChar, i);
            }
        }
        int minIndex = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() != -1 && entry.getValue() < minIndex) {
                minIndex = entry.getValue();
            }
        }
        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }

}
