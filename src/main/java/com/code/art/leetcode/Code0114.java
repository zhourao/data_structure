package com.code.art.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述:
 *
 * @author zhourao
 * @create 2020-10-15 6:00 下午
 */
public class Code0114 {

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int _val) {
            val = _val;
        }

        public TreeNode(int _val, TreeNode _left, TreeNode _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }


    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);
        /**** 后序遍历位置 ****/
        // 1、左右子树已经被拉平成一条链表
        TreeNode temp = root.right;


        // 2、将左子树作为右子树
        root.right = root.left;
        root.left = null;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode curNode = root;
        while (curNode.right != null) {
            curNode = curNode.right;
        }
        curNode.right = temp;
    }


    public static void main(String[] args) {
        TreeNode leftTreeNode = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode rightTreeNode = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        TreeNode root = new TreeNode(1, leftTreeNode, rightTreeNode);

    }
}