package com.height.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.14. 布尔运算
 * https://leetcode-cn.com/problems/boolean-evaluation-lcci/
 * 给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR) 符号组成。实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。
 *
 *
 */
public class No08D14ForJava {
    public int countEval(String s, int result) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = (s.length() - 1) / 2;
        int[] val = new int[len];
        char[] op = new char[len];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                val[i] = s.charAt(i) - '0';
            } else {
                op[i] = s.charAt(i);
            }
        }


        int[][] countSum = new int[val.length][val.length];
        int[][] valueSum = new int[val.length][val.length];
        for (int i = 0; i < val.length; i++) {
            countSum[i] = new int[val.length];
            valueSum[i] = new int[val.length];
        }

        for(int vlen = 1 ; vlen<val.length;vlen++){
            for (int i = 0; i< val.length-1;i++){
                for(int j = i+vlen ;j<val.length;j++){
                    if(vlen == 1){
                        valueSum[i][j] = calResult(val[i],val[j],op[i]);
                        countSum[i][j] = valueSum[i][j] == result ? 1 : 0;
                        continue;
                    }
                    int count = 0;
                    for(int k = i+1 ; k<j ;k++){
//                        count+=sum(i,k,countSum,valueSum)+sum(k,j); //TODO
                    }

                }
            }
        }


    }


    private int calResult(int val1, int val2, char op) {
        switch (op) {
            case '&':
                return val1 & val2;
            case '|':
                return val1 | val2;
            case '^':
                return val1 ^ val2;
            default:
                return 99;
        }
    }

}
