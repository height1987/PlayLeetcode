package com.height.No36;

import java.util.HashMap;
import java.util.Map;

/**
 * 36. 有效的数独
 * https://leetcode-cn.com/problems/valid-sudoku/
 * 思路：数独是横、竖、相邻的9个小正方形内的数字不重复，所以通过2层循环，计算在同一个计算区域中是否有相同的数字
 * 时间复杂度是O(n²)
 */
public class No36ForJava {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }
        Map<Integer, Integer> flags = new HashMap<Integer, Integer>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if ('.' == (board[i][j])) {
                    continue;
                }
                Integer num = (int) board[i][j];
                Integer rowKey = 100 + i * 10 + num;
                Integer colKey = 200 + j * 10 + num;
                Integer cubeKey = 300 + ((j / 3) * 3 + i / 3) * 10 + num;
                if (flags.containsKey(rowKey) || flags.containsKey(colKey) || flags.containsKey(cubeKey)) {
                    return false;
                }
                flags.put(rowKey, 1);
                flags.put(colKey, 1);
                flags.put(cubeKey, 1);
            }
        }
        return true;
    }
}
