package com.somduttasinha.structura.graph;

import java.util.Iterator;
import java.util.Set;

/**
 * A dense graph implementation using an adjacency matrix.
 */
public class DenseGraph<V> implements Graph<V> {

    @Override
    public void addEdge(Vertex<V> from, Vertex<V> to, int weight) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addEdge'");
    }

    @Override
    public boolean hasEdge(Vertex<V> from, Vertex<V> to) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasEdge'");
    }

    @Override
    public Iterator<Vertex<V>> adjacentVertices(Vertex<V> vertex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adjacentVertices'");
    }

    @Override
    public int vertexCount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'vertexCount'");
    }

    @Override
    public int edgeCount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'edgeCount'");
    }

    @Override
    public Set<Vertex<V>> vertices() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'vertices'");
    }

}
