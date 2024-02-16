package com.somduttasinha.structura.graph;

import java.util.Iterator;
import java.util.Set;

/**
 * Graph interface.
 */
public interface Graph<V> {

    void addEdge(Vertex<V> from, Vertex<V> to, int weight);

    boolean hasEdge(Vertex<V> from, Vertex<V> to);

    Iterator<Vertex<V>> adjacentVertices(Vertex<V> vertex);

    int vertexCount();

    int edgeCount();

    Set<Vertex<V>> vertices();

}


