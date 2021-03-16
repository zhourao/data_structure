package com.code.art.structure.graph;

import com.code.art.structure.bag.Bag;

/**
 * 描述: 无向图
 *
 * @author zhourao
 * @create 2021-01-26 3:07 下午
 */
public class Graph {

    private final int V; //定点数目
    private int E; //边的数目

    private Bag<Integer>[] adj; //邻接表

    //创建一个含有V个定点但不好有边的图
    Graph(int V) {
        this.V = V;
        this.E = 0;
        for (int v = 0; v < V; v++) //将所有链表初始化为空
            adj[v] = new Bag<Integer>();

    }

    // 从标准输入流in读入一幅图
    //Graph(In in)

    //定点数
    public int V() {
        return V;
    }

    //变数
    public int E() {
        return E;
    }

    //向图中添加一条边v-w
    public void addEdge(int v, int w) {
        adj[v].add(w); //将w添加到v的链表中
        adj[w].add(v);//将v添加到w的链表中
        E++;
    }

    //和V相邻的所有定点
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    //对象的字符串表示
    public String toString() {
        StringBuilder s = new StringBuilder(V + " vertices, " + E + " edges\n");
        for (int v = 0; v < V; v++) {
            s.append(v).append(": ");
            for (int w : this.adj(v))
                s.append(w).append(" ");
            s.append("\n");
        }
        return s.toString();
    }
}