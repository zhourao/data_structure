package com.code.art.leetcode;

/**
 * 描述:
 *
 * @author zhourao
 * @create 2021-07-09 5:23 下午
 */
public class Code0098 {

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

    public static boolean isValidBST(TreeNode root) {
        return isNodeValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isNodeValidBST(TreeNode node, long low, long upper) {
        if (node == null) return true;
        if (node.val <= low || node.val >= upper) return false;
        return isNodeValidBST(node.left, low, node.val) && isNodeValidBST(node.right, node.val, upper);
    }

    public static void main(String[] args) {
        TreeNode root =
                new TreeNode(0,
                        new TreeNode(-1,
                                new TreeNode(-4,
                                        new TreeNode(-5, null, null),
                                        new TreeNode(-3, null, null)
                                )
                                , null
                        ),
                        new TreeNode(4,
                                new TreeNode(2,
                                        null,
                                        new TreeNode(3, null, null)
                                ),
                                new TreeNode(5,
                                        null,
                                        new TreeNode(8, null, null)
                                )
                        )
                );

        System.out.println(isValidBST(root));
    }
}
