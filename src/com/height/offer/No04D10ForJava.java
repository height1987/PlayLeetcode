package com.height.offer;

/**
 * 面试题 04.10. 检查子树
 * https://leetcode-cn.com/problems/check-subtree-lcci/
 * 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
 * <p>
 * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
 * 示例1:
 * 输入：t1 = [1, 2, 3], t2 = [2]
 * 输出：true
 */
public class No04D10ForJava {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null) {
            return false;
        } else if (t2 == null) {
            return false;
        }
        //当两节点值相同可开始进行对比
        if (t1.val == t2.val) {
            return checkSubTree(t1.left, t2.left) && checkSubTree(t1.right, t2.right);
        } else {
            //两节点值不同，t1继续寻找
            return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2)
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
