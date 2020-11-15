package com.height.offer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 面试题 08.07. 无重复字符串的排列组合
 * https://leetcode-cn.com/problems/permutation-i-lcci/
 * 思路：
 * 1.循环s的每一个字符
 * 2.存储s所有可能的字符串
 * 3.s和s前所有字符串组合生成新的字符串
 *
 * 使用dp的思路
 */
public class No08D07ForJava {

    public String[] permutation(String s) {
        if(s == null || s.length() == 0){
            return null;
        }
        List<String> currentRes = new ArrayList<>();
        currentRes.add(String.valueOf(s.charAt(0)));
        for(int i = 1 ;i < s.length();i++){
            List<String> newres = new ArrayList<>();
            for(int j = 0 ;j < currentRes.size();j++){
                newres.addAll(calNew(String.valueOf(s.charAt(i)),currentRes.get(j)));
            }
            currentRes = newres;
        }
        String[] res = new String[currentRes.size()];
        for(int i = 0 ; i< currentRes.size();i++){
            res[i] = currentRes.get(i);
        }
        return res;
    }
    List<String> calNew(String oneChar , String longString){
        List<String> res= new ArrayList<>();
        for(int i = 0 ; i<longString.length()+1;i++){
            if(i == 0){
                res.add(oneChar+longString);
                continue;
            }
            if( i == longString.length()){
                res.add(longString+oneChar);
                continue;
            }
            res.add(longString.substring(0,i) +
                    oneChar+longString.substring(i,longString.length()));
        }
        return res;
    }
}
