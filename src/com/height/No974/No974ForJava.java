package com.height.No974;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * 974. 和可被 K 整除的子数组
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 */

public class No974ForJava {
    public static int subarraysDivByK(int[] A, int K) {
        if(A == null || A.length == 0){
            return 0;
        }
        if(K == 0){
            return 0;
        }
        int newK = K < 0 ? (K*-1) : K ;
        BigInteger s = new BigInteger("1");

        Map<Integer,Integer> count = new HashMap<Integer,Integer>();
        char ss  = '1';

        count.put(0,1);
        int  preSum = 0;
        for(int i = 0 ; i< A.length ; i++){
            int mokNow = ((A[i] + preSum)%newK + newK)%newK;
            count.put(mokNow,count.getOrDefault(mokNow,0) + 1);
            preSum += A[i];
        }
        int allCount = 0;
        for(Map.Entry<Integer,Integer> key : count.entrySet()){
            allCount += (key.getValue()*(key.getValue()-1)/2);
        }
        return allCount;
    }


}
