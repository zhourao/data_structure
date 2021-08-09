package com.code.art.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author zhourao
 * @create 2021-07-08 7:49 下午
 */
public class Code0094 {
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


    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    private static void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
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

        List<Integer> list = inorderTraversal(root);

        System.out.println(list);
    }
}
