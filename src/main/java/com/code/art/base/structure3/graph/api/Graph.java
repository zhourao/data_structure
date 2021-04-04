package com.code.art.base.structure3.graph.api;

/**
 * 描述: 图的接口
 *
 * @author zhourao
 * @create 2021-04-04 10:26 上午
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