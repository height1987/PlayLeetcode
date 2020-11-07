package com.height.offer;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 面试题 10.02. 变位词组
 * https://leetcode-cn.com/problems/group-anagrams-lcci/
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class No10D02ForJava {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        Map<String,List<String>> res = new HashMap<>();
        Arrays.stream(strs).forEach(str->{
            String key = calNum(str);
            List<String> one = res.getOrDefault(key, new ArrayList<>());
            one.add(str);
            res.put(key,one);
        });
        List<List<String>> result = new ArrayList<>();
        res.forEach((key, value) -> result.add(value));
        return result;
    }

    public String calNum(String s) {
        if (s == null) {
            return "-1";
        }
        if ("".equals(s)) {
            return "0";
        }
        char[] charList = s.toCharArray();
        Arrays.sort(charList);
        return Arrays.toString(charList);
    }
}
