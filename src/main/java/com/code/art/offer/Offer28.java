package com.code.art.offer;

/**
 * 描述: 对称的二叉树
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 *
 * @author zhourao
 * @create 2021-04-13 9:53 下午
 */
public class Offer28 {

    /**
     * 【题目】二叉树的镜像
     * 【题目说明】
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
     * 1
     * / \
     * 2  2
     * / \ / \
     * 3 4 4 3
     * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
     * 1
     * / \
     * 2  2
     * \  \
     * 3  3
     * 【示例】
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
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