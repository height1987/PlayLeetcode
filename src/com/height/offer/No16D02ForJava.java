package com.height.offer;

import java.util.HashMap;

/**
 * 面试题 16.02. 单词频率
 * https://leetcode-cn.com/problems/words-frequency-lcci/
 * 设计一个方法，找出任意指定单词在一本书中的出现频率。
 *
 * 你的实现应该支持如下操作：
 *
 * WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
 * get(word)查询指定单词在书中出现的频率
 * 示例：
 *
 * WordsFrequency wordsFrequency = new WordsFrequency({"i", "have", "an", "apple", "he", "have", "a", "pen"});
 * wordsFrequency.get("you"); //返回0，"you"没有出现过
 * wordsFrequency.get("have"); //返回2，"have"出现2次
 * wordsFrequency.get("an"); //返回1
 * wordsFrequency.get("apple"); //返回1
 * wordsFrequency.get("pen"); //返回1
 *
 *  思路：直接把word进行索引，放到map中去，key是word，value是出现次数
 *  get方法直接从map中取
 *
 */
public class No16D02ForJava {
    private HashMap<String, Integer> res = new HashMap<>();

    public No16D02ForJava(String[] book) {
        for (String word : book) {
            res.put(word, res.getOrDefault(word, 0) + 1);
        }
    }

    public int get(String word) {
        return res.getOrDefault(word, 0);
    }

}
