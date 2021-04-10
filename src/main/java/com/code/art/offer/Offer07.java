package com.code.art.offer;


import java.util.HashMap;

/**
 * 描述: 重建二叉树
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 *
 * @author zhourao
 * @create 2021-04-10 9:28 上午
 */
public class Offer07 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 【题目】重建二叉树
     * 【题目说明】
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 
     * 【示例】
     * 例如，给出
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     */

    HashMap<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, preorder, 0, inorder.length - 1);
    }

    TreeNode recur(int root, int[] preorder, int left, int right) {
        if (left > right) return null;                          // 递归终止

        TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        node.left = recur(root + 1, preorder, left, i - 1);              // 开启左子树递归
        node.right = recur(root + i - left + 1, preorder, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }


    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        Offer07 o = new Offer07();
        TreeNode treeNode = o.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}