package com.code.art.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述: https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 *
 * @author zhourao
 * @create 2020-10-15 6:00 下午
 */
public class Code116 {

    static class Node {
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


    public static Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        int i = 1;
        Node prevNode = root;
        while (!queue.isEmpty()) {
            Node tempTreeNode = queue.remove();
            if (((i - 1) & i) != 0) prevNode.next = tempTreeNode;
            i++;
            prevNode = tempTreeNode;

            if (tempTreeNode.left != null)
                queue.add(tempTreeNode.left);
            if (tempTreeNode.right != null)
                queue.add(tempTreeNode.right);
        }
        return root;
    }

    public static Node connect2(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // 记录当前队列大小
            int size = queue.size();

            // 遍历这一层的所有节点
            for (int i = 0; i < size; i++) {
                // 从队首取出元素
                Node node = queue.poll();
                // 连接
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                // 拓展下一层节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public static Node connect3(Node root) {
        dfs(root, null);
        return root;
    }

    private static void dfs(Node curr, Node next) {
        if (curr == null)
            return;
        curr.next = next;
        dfs(curr.left, curr.right);
        dfs(curr.right, curr.next == null ? null : curr.next.left);
    }

    public static void main(String[] args) {
        Node leftNode = new Node(2, new Node(4), new Node(5), null);
        Node rightNode = new Node(3, new Node(6), new Node(7), null);
        Node root = new Node(1, leftNode, rightNode, null);

        connect(root);
    }
}