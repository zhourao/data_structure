package com.code.art.offer;

/**
 * 描述: 二叉树的镜像
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 *
 * @author zhourao
 * @create 2021-04-13 9:53 下午
 */
public class Offer27 {

    /**
     * 【题目】二叉树的镜像
     * 【题目说明】
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     * 例如输入：
     * 4
     * /  \
     * 2   7
     * / \  / \
     * 1  3 6  9
     * 镜像输出：
     * 4
     * /  \
     * 7   2
     * / \  / \
     * 9  6 3 1
     * 【示例】
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
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