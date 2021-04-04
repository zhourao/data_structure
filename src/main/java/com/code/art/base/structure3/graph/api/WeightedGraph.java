package com.code.art.base.structure3.graph.api;

import com.code.art.base.structure3.graph.base.Edge;

/**
 * 描述:有权图的接口
 *
 * @author zhourao
 * @create 2021-04-04 12:29 下午
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