package com.code.art.offer;

/**
 * 描述: 树的子结构
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 *
 * @author zhourao
 * @create 2021-04-13 9:53 下午
 */
public class Offer26 {

    /**
     * 【题目】树的子结构
     * 【题目说明】
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     * 例如:
     * 给定的树 A:
     * 3
     * / \
     * 4   5
     * / \
     * 1   2
     * 给定的树 B：
     * 4
     * /
     * 1
     * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
     * 【示例】
     * 输入：A = [1,2,3], B = [3,1]
     * 输出：false
     * 输入：A = [3,4,5,1,2], B = [4,1]
     * 输出：true
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
    }
}