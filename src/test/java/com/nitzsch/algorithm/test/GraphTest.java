package com.nitzsch.algorithm.test;

import com.nitzsch.algorithm.graph.Graph;
import org.junit.Test;

/**
 * @author: nitzschhong
 * @create: 2022-04-10 11:33
 */
public class GraphTest {
    @Test
    public void testBFS() {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        graph.bfs(0, 6);
    }
}
