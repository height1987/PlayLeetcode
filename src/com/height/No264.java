package com.height;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/ugly-number-ii/
 */
public class No264 {


    public static void main(String[] args) {

        System.out.print(Arrays.toString(get(20)));
    }

    public static int[] get(int n) {
        int[] holder = new int[n + 1];
        holder[1] = 1;
        int size2 = 1, size3 = 1, size5 = 1;
        for (int i = 2;i< n+1;i++){
            int min = min((holder[size2]*2),(holder[size3]*3),holder[size5]*5);
            holder[i] = min;
            if(min == (holder[size2]*2)){
                size2++;
            }
            if(min == (holder[size3]*3)){
                size3++;
            }
            if(min == holder[size5]*5){
                size5++;
            }
        }
        return holder;
    }

    public static int min(int a,int b ,int c){
        return Math.min(Math.min(a,b),c);
    }


}
