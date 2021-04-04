package com.code.art.base.structure3.graph.tools01;

import com.code.art.base.structure3.graph.api.Graph;

/**
 * 描述: 对图G随机生成边,边的个数的期望值为E
 *
 * @author zhourao
 * @create 2021-04-04 12:18 下午
 */
public class RandomGraph {

    public RandomGraph(Graph graph, int V, int E) {
        double p = (double) 2 * E / (V * (V - 1));
        for (int i = 0; i < V; i++)
            for (int j = i + 1; j < V; j++) {

                double randomValue = Math.random();
                if (randomValue < p) {
                    graph.addEdge(i, j);
                }
            }
    }
}