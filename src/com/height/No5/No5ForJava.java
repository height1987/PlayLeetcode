package com.height.No5;

/**
 * 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 题目：给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 解题思路：通过构造一个记录子串是否为回文串的数组，迭代公式为resFlag[i][j] = resFlag[i+1][j-1] && char[i]==char[j]
 */
public class No5ForJava {
    public String longestPalindrome(String s) {
        if (s == null) {
            return "";
        }
        if (s.length() < 2) {
            return s;
        }

        int begin = 0;
        int maxLen = 1;
        boolean[][] resFlag = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            resFlag[i][i] = true;
        }

        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    resFlag[i][j] = false;
                } else {
                    if (j - i < 3) {
                        resFlag[i][j] = true;
                    } else {
                        resFlag[i][j] = resFlag[i + 1][j - 1];
                    }
                }
                int currentLen = j - i + 1;
                if (resFlag[i][j] && currentLen > maxLen) {
                    maxLen = currentLen;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);

    }

}
