# 3个算基础数据结构，你掌握了多少？

# 1 概述

## 1.1 5种基础数据结构

| 序号 | 结构 |
| ------ | ------ |
| 1 | 二叉树 |
| 2 | 并查集 |
| 3 | 图 |

## 1.2 约定

类及位置

```java
package com.code.art.base.structure3;
```

# 2 结构详解

## 2.1 二叉树

```java
import com.code.art.base.structure3.BinarySearchTree;
```

### 数据结构定义

```java
public class BinarySearchTree<K extends Comparable<K>, V> {

    private class Node {//链表节点的定义

        private final K key; //键

        private V val; //值

        private Node left, right; //指向子树的链接

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public Node(Node node) {
            this.key = node.key;
            this.val = node.val;
            this.left = node.left;
            this.right = node.right;
        }
    }

    private Node root; //根结点
    private int count;  // 树种的节点个数

    // 构造函数, 默认构造一棵空二分搜索树
    public BinarySearchTree() {
        root = null;
    }

    // 返回二分搜索树的节点个数
    public int size() {
        return count;
    }

    // 返回二分搜索树是否为空
    public boolean isEmpty() {
        return count == 0;
    }
}
```

### 插入数据

```java
public class BinarySearchTree<K extends Comparable<K>, V> {

    // 省略代码

    //向二分搜索树中插入一个新的(key,val)数据对
    public void put(K key, V val) {
        //查找key，找到则更新它的值，否则则为它创建一个新的节点
        put(root, key, val);
    }

    //向以node为根的二分搜索树中，插入节点(key,val)，使用递归算法
    //返回插入新节点后的二分搜索树的根
    private Node put(Node x, K key, V val) {
        if (x == null) {
            count++;
            return new Node(key, val);
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        return x;
    }
}
```

### 是否包含key

```java

public class BinarySearchTree<K extends Comparable<K>, V> {
    // 查看二分搜索树中是否存在键key
    public boolean contain(K key) {
        return contain(root, key);
    }

    // 查看以node为根的二分搜索树中是否包含键值为key的节点, 使用递归算法
    private boolean contain(Node node, K key) {
        if (node == null)
            return false;

        int cmp = key.compareTo(node.key);
        if (cmp == 0)
            return true;
        else if (cmp < 0)
            return contain(node.left, key);
        else // key > node->key
            return contain(node.right, key);
    }
}
```

### 查找数据

```java
public class BinarySearchTree<K extends Comparable<K>, V> {
    // 在二分搜索树中搜索键key所对应的值。如果这个值不存在, 则返回null
    public V search(K key) {
        return search(root, key);
    }

    // 在以node为根的二分搜索树中查找key所对应的value, 递归算法
    // 若value不存在, 则返回NULL
    private V search(Node node, K key) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if (cmp == 0)
            return node.val;
        else if (cmp < 0)
            return search(node.left, key);
        else // key > node->key
            return search(node.right, key);
    }
}
```

### 4种遍历

* 前序遍历
* 中序遍历
* 后序遍历
* 层序遍历

```java
public class BinarySearchTree<K extends Comparable<K>, V> {
    // ①二分搜索树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    // 对以node为根的二叉搜索树进行前序遍历, 递归算法
    private void preOrder(Node node) {

        if (node != null) {
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // ②二分搜索树的中序遍历
    public void inOrder() {
        inOrder(root);
    }

    // 对以node为根的二叉搜索树进行中序遍历, 递归算法
    private void inOrder(Node node) {

        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    // ③二分搜索树的后序遍历
    public void postOrder() {
        postOrder(root);
    }

    // 对以node为根的二叉搜索树进行后序遍历, 递归算法
    private void postOrder(Node node) {

        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }

    // ④二分搜索树的层序遍历
    public void levelOrder() {
        // 使用LinkedList来作为我们的队列
        LinkedList<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.remove();

            System.out.println(node.key);
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
    }
}

```

### 寻找最大值&最小值

* 查找最小值
* 查找最大值

```java
public class BinarySearchTree<K extends Comparable<K>, V> {
    // ①寻找二分搜索树的最小的键值
    public K minimum() {
        assert count != 0;
        Node minNode = minimum(root);
        return minNode.key;
    }

    // 返回以node为根的二分搜索树的最小键值所在的节点
    private Node minimum(Node node) {
        if (node.left == null)
            return node;

        return minimum(node.left);
    }

    // ②寻找二分搜索树的最大的键值
    public K maximum() {
        assert count != 0;
        Node maxNode = maximum(root);
        return maxNode.key;
    }

    // 返回以node为根的二分搜索树的最大键值所在的节点
    private Node maximum(Node node) {
        if (node.right == null)
            return node;

        return maximum(node.right);
    }
}
```

### 数据删除

* 删除最小值
* 删除最大值
* 删除任意值

```java
public class BinarySearchTree<K extends Comparable<K>, V> {

    // 从二分搜索树中删除最小值所在节点
    public void removeMin() {
        if (root != null)
            root = removeMin(root);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            count--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }


    // 从二分搜索树中删除最大值所在节点
    public void removeMax() {
        if (root != null)
            root = removeMax(root);
    }


    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            count--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }


    // 从二分搜索树中删除键值为key的节点
    public void remove(K key) {
        root = remove(root, key);
    }

    // 删除掉以node为根的二分搜索树中键值为key的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
    Node remove(Node node, K key) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (cmp > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {   // key == node->key

            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                count--;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                count--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = new Node(minimum(node.right));
            count++;

            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            count--;

            return successor;
        }
    }
}
```

## 2.2 并查集

```java
import com.code.art.base.structure3.UnionFind;
```

### 数据结构定义

```java
package com.code.art.base.structure3;

public class UnionFind {

    //rank[i]表示以i为根的集合所表示的树的层数
    //在后续的代码中，我们并不会维护rank的语意，也就是rank的值在路径压缩的过程中，有可能不在树的层数值
    // 这也是我们的rank不叫height或者depth的原因, 他只是作为比较的一个标准
    private int[] rank;

    private int[] parent; //parent[i]表示第i个元素所指向的父节点
    private int count; //数据个数

    // 构造函数
    public UnionFind(int count) {
        rank = new int[count];
        parent = new int[count];
        this.count = count;
        // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
}
```

### 连接查询

```java
package com.code.art.base.structure3;

public class UnionFind {

    // 查看元素p和元素q是否所属一个集合
    // O(h)复杂度, h为树的高度
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 查找过程, 查找元素p所对应的集合编号
    // O(h)复杂度, h为树的高度
    private int find(int p) {
        assert (p >= 0 && p < count);

        // path compression 1
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}
```

### 连接操作

```java
package com.code.art.base.structure3;

public class UnionFind {
    // 合并元素p和元素q所属的集合
    // O(h)复杂度, h为树的高度
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        // 根据两个元素所在树的元素个数不同判断合并方向
        // 将元素个数少的集合合并到元素个数多的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else { // rank[pRoot] == rank[qRoot]
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;   // 此时, 我维护rank的值
        }
    }
}
```

## 2.3 图

```java

// 无权图 接口
import com.code.art.base.structure3.graph.api.Graph;
// 有权图 接口
import com.code.art.base.structure3.graph.api.WeightedGraph;

// 无权稀疏图
import com.code.art.base.structure3.graph.impl.SparseGraph;
// 无权稠密图
import com.code.art.base.structure3.graph.impl.DenseGraph;
// 有权稀疏图
import com.code.art.base.structure3.graph.impl.SparseWeightedGraph;
// 有权稠密图
import com.code.art.base.structure3.graph.impl.DenseWeightedGraph;
```

### 2.3.1 接口
* 无权图
```java
package com.code.art.base.structure3.graph.api;

/**
 * 描述: 图的接口
 */
public interface Graph {

    //返回节点个数
    int V();

    //返回边的个数
    int E();

    //向图中添加一个边
    void addEdge(int v, int w);

    //验证图中是否有从v到w的边
    boolean hasEdge(int v, int w);

    //显示图的信息
    void show();

    //返回图中一个顶点的所有邻边
    Iterable<Integer> adj(int v);
}
```

* 有权图
```java
package com.code.art.base.structure3.graph.api;

import com.code.art.base.structure3.graph.base.Edge;

/**
 * 描述:有权图的接口
 */
public interface WeightedGraph<Weight extends Number & Comparable> {

    //返回节点个数
    int V();

    //返回边的个数
    int E();

    //向图中添加一个边
    void addEdge(Edge<Weight> e);

    //验证图中是否有从v到w的边
    boolean hasEdge(int v, int w);

    //显示图的信息
    void show();

    //返回图中一个顶点的所有邻边
    Iterable<Edge<Weight>> adj(int v);
}
```

### 2.3.2 第1部分：基础



### 2.3.3 第2部分：提升

### 2.3.4 第3部分：进阶