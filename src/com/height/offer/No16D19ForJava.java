package com.height.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pond-sizes-lcci/
 *
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。
 * 若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。
 * 编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 *
 */
public class No16D19ForJava {
    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        if(land.length==0)  return new int [0];
        int temp = 0;
        for(int i = 0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                if(land[i][j]==0){
                    temp = dfs(land,i,j);
                    list.add(temp);
                }
            }
        }
        list.sort((o1,o2)-> o1-o2);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    private int dfs(int [][]land,int i,int j){
        if(i<0||j<0||i>=land.length||j>=land[0].length||land[i][j]!=0)  return 0;
        land[i][j] = 3;
        int area = 1;
        area += dfs(land,i-1,j-1);
        area += dfs(land,i-1,j+1);
        area += dfs(land,i,j+1);
        area += dfs(land,i,j-1);
        area += dfs(land,i-1,j);
        area += dfs(land,i+1,j);
        area += dfs(land,i+1,j-1);
        area += dfs(land,i+1,j+1);
        return area;
    }

}
