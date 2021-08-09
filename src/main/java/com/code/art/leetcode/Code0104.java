package com.code.art.leetcode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 描述:二叉树的最大深度
 *
 * @author zhourao
 * @create 2021-07-07 4:16 下午
 */
public class Code0104 {

    //Definition for a binary tree node.
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        Queue<TreeNode> a = new LinkedBlockingDeque<>();
//        a.add(root);
//        int depth = 0;
//        while (!a.isEmpty()) {
//            int size = a.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode e = a.remove();
//                if (e.left != null) {
//                    a.add(e.left);
//                }
//                if (e.right != null) {
//                    a.add(e.right);
//                }
//            }
//            depth++;
//        }
//        return depth;
        return maxDepth(root, 0);
    }

    private static int maxDepth(TreeNode node, int depth) {
        if (node == null) return depth;
        return Math.max(maxDepth(node.left, depth + 1), maxDepth(node.right, depth + 1));
    }

    public static void main(String[] args) {
        TreeNode root =
                new TreeNode(0,
                        new TreeNode(2,
                                new TreeNode(1,
                                        new TreeNode(5, null, null),
                                        new TreeNode(1, null, null)
                                )
                                , null
                        ),
                        new TreeNode(4,
                                new TreeNode(3,
                                        null,
                                        new TreeNode(6, null, null)
                                ),
                                new TreeNode(-1,
                                        null,
                                        new TreeNode(8, null, null)
                                )
                        )
                );

        System.out.println(maxDepth(root));
    }
}
