package com.code.art.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 描述:
 *
 * @author zhourao
 * @create 2021-07-07 4:42 下午
 */
public class Code0102 {

    public static class TreeNode {
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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedBlockingDeque<>();
        List<List<Integer>> list = new ArrayList<>();

        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode e = q.remove();
                l.add(e.val);
                if (e.left != null) {
                    q.add(e.left);
                }
                if (e.right != null) {
                    q.add(e.right);
                }
            }
            list.add(l);
        }
        return list;
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

        List<List<Integer>> list = levelOrder(root);

        System.out.println(list);
    }
}
