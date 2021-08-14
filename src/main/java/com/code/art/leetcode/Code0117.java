package com.code.art.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述:填充每个节点的下一个右侧节点指针 II https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 *
 * @author zhourao
 * @create 2021-08-14 5:07 下午
 */
public class Code0117 {

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node e = queue.poll();
                if (e.left != null) {
                    queue.add(e.left);
                }
                if (e.right != null) {
                    queue.add(e.right);
                }
                e.next = i == size - 1 ? null : queue.peek();
            }
        }
        return root;
    }
}
