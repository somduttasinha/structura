package com.somduttasinha.structura.graph;

import java.util.Iterator;

/**
 * Graph interface.
 */
public interface Graph<V> {

    void addEdge(Vertex<V> from, Vertex<V> to, int weight);

    boolean hasEdge(Vertex<V> from, Vertex<V> to);

    Iterator <Vertex<V>> adjacentVertices(Vertex<V> vertex);

    int vertexCount();

    int edgeCount();

}


