package com.code.art.search;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 描述:红黑树（与2-3树是相同的）
 * 性质：
 * ①红链接均为左链接
 * ②没有任何一个结点同时和两条红链接相连
 * ③该树是完美黑色平衡的，即任意空链接到根节点的路径上的黑链接数量相同
 * <p>
 * 目的：
 * 通过旋转操作可以保证红黑树的两个主要特性：有序性和完美平衡性
 * <p>
 * 操作：
 * ①如果右子结点是红色的而左子结点是黑色的，进行左旋转
 * ②如果左子结点是红色的且它的左子结点也是红色的，进行右旋转；
 * ③如果左右子结点均为红色，进行颜色转换
 *
 * @author zhourao
 * @create 2021-01-12 3:43 下午
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        Key key;            //键
        Value val;          //相关联的值
        Node left, right;   //左右子树
        int N;              //这颗子树中的结点总数
        boolean color;      //由其父节点指向它的连接的颜色

        Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    private Node root;

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;

        x.color = RED;

        x.N = h.N;
        h.N = 1 + size(h.right) + size(h.left);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;

        x.color = h.color;
        h.color = RED;

        x.N = h.N;
        h.N = 1 + size(h.right) + size(h.left);
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null) //标准的插入操作，和父节点用红链接相连
            return new Node(key, val, 1, RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

}